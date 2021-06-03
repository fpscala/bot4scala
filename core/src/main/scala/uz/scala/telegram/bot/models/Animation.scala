package uz.scala.telegram.bot.models

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 *
 * @param file_id        String	Identifier for this file, which can be used to download or reuse the file
 * @param file_unique_id String	Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @param width          Integer	Video width as defined by sender
 * @param height         Integer	Video height as defined by sender
 * @param duration       Integer	Duration of the video in seconds as defined by sender
 * @param thumb          PhotoSize	Optional. Animation thumbnail as defined by sender
 * @param file_name      String	Optional. Original animation filename as defined by sender
 * @param mime_type      String	Optional. MIME type of the file as defined by sender
 * @param file_size      Integer	Optional. File size
 *
 * */
case class Animation(
  file_id: String,
  file_unique_id: String,
  width: Int,
  height: Int,
  duration: Int,
  thumb: Option[PhotoSize] = None,
  file_name: Option[String] = None,
  mime_type: Option[String] = None,
  file_size: Option[Int] = None
)
