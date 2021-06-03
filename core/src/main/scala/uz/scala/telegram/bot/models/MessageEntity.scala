package uz.scala.telegram.bot.models

/**
 * MessageEntity
 *
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 *
 * @param type     String	Type of the entity. Can be “mention” (@username), “hashtag” (#hashtag), “cashtag” ($USD), “bot_command” (/start@jobs_bot), “url” (https://telegram.org), “email” (do-not-reply@telegram.org), “phone_number” (+1-212-555-0123), “bold” (bold text), “italic” (italic text), “underline” (underlined text), “strikethrough” (strikethrough text), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users without usernames)
 * @param offset   Integer	Offset in UTF-16 code units to the start of the entity
 * @param length   Integer	Length of the entity in UTF-16 code units
 * @param url      String	Optional. For “text_link” only, url that will be opened after user taps on the text
 * @param user     User	Optional. For “text_mention” only, the mentioned user
 * @param language String	Optional. For “pre” only, the programming language of the entity text
 * */
case class MessageEntity(
  `type`: String,
  offset: Int,
  length: Int,
  url: Option[String] = None,
  user: Option[User] = None,
  language: Option[String] = None
)
