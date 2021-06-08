package api

import uz.scala.telegram.bot.models.ResponseParameters

/**
 * Telegram API errors, e.g. when `response.ok` is false.
 * Does not wrap exceptions related to de/serialization, network errors...
 */
case class TelegramApiException(
  message: String,
  errorCode: Int,
  cause: Option[Throwable] = None,
  parameters: Option[ResponseParameters] = None
) extends RuntimeException(message, cause.orNull)
