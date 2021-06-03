package uz.scala.telegram.bot.models

import java.io.File

object InputFilePimps {
  implicit def toInputFile(file: File) : InputFile = InputFile(file)
}
