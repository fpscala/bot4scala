package uz.scala.telegram.bot.models

/**
 * Document
 *
 * This object represents a general file (as opposed to photos and audio files).
 *
 * @param fileId       String	Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId String	Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @param thumb        PhotoSize	Optional. Document thumbnail as defined by sender
 * @param fileName     String	Optional. Original filename as defined by sender
 * @param mimeType     String	Optional. MIME type of the file as defined by sender
 * @param fileSize     Integer	Optional. File size
 */
case class Document(
  fileId      : String,
  fileUniqueId: String,
  thumb       : Option[PhotoSize] = None,
  fileName    : Option[String] = None,
  mimeType    : Option[String] = None,
  fileSize    : Option[Int] = None
)
