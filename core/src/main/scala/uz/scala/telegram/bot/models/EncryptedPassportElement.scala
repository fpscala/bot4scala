package uz.scala.telegram.bot.models

/**
 * EncryptedPassportElement
 *
 * Contains information about documents or other Telegram Passport elements shared with the bot by the user.
 *
 * @param type         String	Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
 * @param data         String	Optional. Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying EncryptedCredentials.
 * @param phone_number String	Optional. User's verified phone number, available only for “phone_number” type
 * @param email        String	Optional. User's verified email address, available only for “email” type
 * @param files        Array of PassportFile	Optional. Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying EncryptedCredentials.
 * @param front_side   PassportFile	Optional. Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
 * @param reverse_side PassportFile	Optional. Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
 * @param selfie       PassportFile	Optional. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
 * @param translation  Array of PassportFile	Optional. Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying EncryptedCredentials.
 * @param hash         String	Base64-encoded element hash for using in PassportElementErrorUnspecified
 * */
case class EncryptedPassportElement(
  `type`: String,
  data  : Option[String] = None,
  phone_number  : Option[String] = None,
  email  : Option[String] = None,
  files  : Option[Array[PassportFile]] = None,
  front_side  : Option[PassportFile] = None,
  reverse_side  : Option[PassportFile] = None,
  selfie  : Option[PassportFile] = None,
  translation  : Option[PassportFile] = None,
  hash  : Option[PassportFile] = None
)
