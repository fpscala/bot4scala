package uz.scala.telegram.bot.models

/**
 * PassportFile
 *
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.
 *
 * @param file_id        String	Identifier for this file, which can be used to download or reuse the file
 * @param file_unique_id String	Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @param file_size      Integer	File size
 * @param file_date      Integer	Unix time when the file was uploaded
 * */
case class PassportFile(
  file_id: String,
  file_unique_id: String,
  file_size: Int,
  file_date: Int
)
