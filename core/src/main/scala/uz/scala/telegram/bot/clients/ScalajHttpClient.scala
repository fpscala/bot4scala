package uz.scala.telegram.bot.clients

import io.circe.parser.parse
import io.circe.{Decoder, Encoder}
import scalaj.http.{Http, MultiPart}
import uz.scala.telegram.bot.api.RequestHandler
import uz.scala.telegram.bot.marshalling
import uz.scala.telegram.bot.methods.{JsonRequest, MultipartRequest, Request, Response}
import uz.scala.telegram.bot.models.InputFile

import java.net.Proxy
import java.nio.file.Files
import scala.concurrent.{ExecutionContext, Future, blocking}

/** Scalaj-http Telegram Bot API client
 *
 * Provide transparent camelCase <-> underscore_case conversions during serialization/deserialization.
 *
 * The Scalaj-http client only supports the following InputFiles:
 * InputFile.FileId
 * InputFile.Contents
 * InputFile.Path
 *
 * It throws UnsupportedOperationException if the InputFile type is not supported
 * e.g InputFile.ByteString
 *
 * Note that the exception is thrown from the method,
 * it's not silently wrapped in the returning Future.
 *
 * @param token Bot token
 */
class ScalajHttpClient(token: String, telegramHost: String = "api.telegram.org")
  (implicit ec: ExecutionContext) extends RequestHandler[Future] {

  val connectionTimeoutMs = 10000 // default 1000
  val readTimeoutMs       = 50000 // default 5000
  val proxy: Proxy        = Proxy.NO_PROXY
  private val apiBaseUrl = s"https://$telegramHost/bot$token/"

  def sendRequest[R, T <: Request[_]](request: T)(implicit encT: Encoder[T], decR: Decoder[R]): Future[R] = {
    val url = apiBaseUrl + request.methodName

    val scalajRequest = request match {
      case _: JsonRequest[_] =>
        Http(url)
          .postData(marshalling.toJson(request))
          .header("Content-Type", "application/json")

      case r: MultipartRequest[_] =>
        // InputFile.FileIds are encoded as query params.
        val (fileIds, files) = r.getFiles.partition {
          case (_, _: InputFile.FileId) => true
          case _                          => false
        }

        val parts = files.map { case (camelKey, inputFile) =>
          val key = marshalling.snakenize(camelKey)
          inputFile match {
            case InputFile.FileId(id) =>
              throw new RuntimeException(s"InputFile.FileId($id) cannot must be encoded as a query param")

            case InputFile.Contents(filename, contents) =>
              MultiPart(key, filename, "application/octet-stream", contents)

            case InputFile.Path(path) =>
              MultiPart(
                key,
                path.getFileName.toString,
                "application/octet-stream",
                Files.newInputStream(path),
                Files.size(path),
                _ => ()
              )

            case other =>
              throw new RuntimeException(s"InputFile $other not supported")
          }
        }

        val fields = parse(marshalling.toJson(request)).fold(
          throw _,
          _.asObject.map {
            _.toMap.mapValues { json =>
              json.asString.getOrElse(json.printWith(marshalling.printer))
            }
          }
        )

        val fileIdsParams = fileIds.map { case (key, inputFile: InputFile.FileId) =>
          marshalling.snakenize(key) -> inputFile.fileId
        }

        val params = fields.getOrElse(Map())

        Http(url).params((params ++ fileIdsParams).toSeq).postMulti(parts: _*)
    }
    import marshalling.responseDecoder
    Future {
      blocking {
        scalajRequest
          .timeout(connectionTimeoutMs, readTimeoutMs)
          .proxy(proxy)
          .asString
      }
    } map { x =>
      if (x.isSuccess)
        marshalling.fromJson[Response[R]](x.body)
      else
        throw new RuntimeException(s"Error ${x.code} on request")
    } map (processApiResponse[R])
  }

}