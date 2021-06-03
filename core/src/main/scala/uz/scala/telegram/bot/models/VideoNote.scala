package uz.scala.telegram.bot.models

/**
 * VideoNote
 * This object represents a video message (available in Telegram apps as of v.4.0).
 *
 * @param file_id        String	Identifier for this file, which can be used to download or reuse the file
 * @param file_unique_id String	Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @param length         Integer	Video width and height (diameter of the video message) as defined by sender
 * @param duration       Integer	Duration of the video in seconds as defined by sender
 * @param thumb          PhotoSize	Optional. Video thumbnail
 * @param file_size      Integer	Optional. File size
 *
 * */
case class VideoNote(
  file_id       : String,
  file_unique_id: String,
  length        : Int,
  duration      : Int,
  thumb         : Option[PhotoSize] = None,
  file_size     : Option[String] = None
)
