package uz.scala.telegram.bot.models

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
 * @param can_send_messages         Boolean Optional. True, if the user is allowed to send text messages, contacts, locations and venues
 * @param can_send_media_messages   Boolean Optional. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * @param can_send_polls            Boolean Optional. True, if the user is allowed to send polls, implies can_send_messages
 * @param can_send_other_messages   Boolean Optional. True, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages
 * @param can_add_web_page_previews Boolean Optional. True, if the user is allowed to add web page previews to their messages, implies can_send_media_messages
 * @param can_change_info           Boolean Optional. True, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
 * @param can_invite_users          Boolean Optional. True, if the user is allowed to invite new users to the chat
 * @param can_pin_messages          Boolean Optional. True, if the user is allowed to pin messages. Ignored in public supergroups
 */
case class ChatPermissions(
  can_send_messages        : Option[Boolean] = None,
  can_send_media_messages  : Option[Boolean] = None,
  can_send_polls           : Option[Boolean] = None,
  can_send_other_messages  : Option[Boolean] = None,
  can_add_web_page_previews: Option[Boolean] = None,
  can_change_info          : Option[Boolean] = None,
  can_invite_users         : Option[Boolean] = None,
  can_pin_messages         : Option[Boolean] = None
)
