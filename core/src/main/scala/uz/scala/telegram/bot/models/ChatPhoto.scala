package uz.scala.telegram.bot.models

/**
 * This object represents a chat photo.
 *
 * @param small_file_id        String File identifier of small (160x160) chat photo. This file_id can be used only for photo download.
 * @param small_file_unique_id String File unique identifier of small chat photo.
 * @param big_file_id          String File identifier of big (640x640) chat photo. This file_id can be used only for photo download.
 * @param big_file_unique_id   String File unique identifier of big chat photo.
 */
case class ChatPhoto(
  small_file_id       : String,
  small_file_unique_id: String,
  big_file_id         : String,
  big_file_unique_id  : String
)
