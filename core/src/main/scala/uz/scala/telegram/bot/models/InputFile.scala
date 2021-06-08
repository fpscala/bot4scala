package uz.scala.telegram.bot.models

import java.io.{File, FileInputStream, InputStream}

/**
 * Created by mukel on 8/16/15.
 */
trait InputFile

object InputFile {
  final case class FileId(fileId: String)                            extends InputFile
  final case class Path(path: java.nio.file.Path)                    extends InputFile
  final case class Contents(filename: String, contents: Array[Byte]) extends InputFile

  def apply(fileId: String): InputFile                          = FileId(fileId)
  def apply(path: java.nio.file.Path): InputFile                = Path(path)
  def apply(filename: String, contents: Array[Byte]): InputFile = Contents(filename, contents)
}