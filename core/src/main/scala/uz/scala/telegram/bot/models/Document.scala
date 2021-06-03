package uz.scala.telegram.bot.models

/**
 * Document
 *
 * This object represents a general file (as opposed to photos and audio files).
 *
 * @param file_id        String	Identifier for this file, which can be used to download or reuse the file
 * @param file_unique_id String	Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @param thumb          PhotoSize	Optional. Document thumbnail as defined by sender
 * @param file_name      String	Optional. Original filename as defined by sender
 * @param mime_type      String	Optional. MIME type of the file as defined by sender
 * @param file_size      Integer	Optional. File size
 */
case class Document(
  file_id                : String,
  file_unique_id         : String,
  thumb                  : Option[PhotoSize] = None,
  file_name              : Option[String] = None,
  mime_type              : Option[String] = None,
  file_size              : Option[Int] = None
)
