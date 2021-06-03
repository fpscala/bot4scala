package uz.scala.telegram.bot.models

import uz.scala.telegram.bot.models.ChatType.ChatType

/**
 * This object represents a chat.
 *
 * @param id                       Integer Unique identifier for this chat, not exceeding 1e13 by absolute value
 * @param type                     String	Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * @param title                    String	Optional. Title, for supergroups, channels and group chats
 * @param username                 String	Optional. Username, for private chats, supergroups and channels if available
 * @param first_name               String Optional. First name of the other party in a private chat
 * @param last_name                String Optional. Last name of the other party in a private chat
 * @param photo                    ChatPhoto Optional. Chat photo. Returned only in getChat.
 * @param bio                      String Optional. Bio of the other party in a private chat. Returned only in getChat.
 * @param description              String	Optional. Description, for groups, supergroups and channel chats. Returned only in getChat.
 * @param invite_link              String Optional. Primary invite link, for groups, supergroups and channel chats. Returned only in getChat.
 * @param pinned_message           Message Optional. The most recent pinned message (by sending date). Returned only in getChat.
 * @param permissions              ChatPermissions	Optional. Default chat member permissions, for groups and supergroups. Returned only in getChat.
 * @param slow_mode_delay          Integer	Optional. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in getChat.
 * @param message_auto_delete_time Integer	Optional. The time after which all messages sent to the chat will be automatically deleted; in seconds. Returned only in getChat.
 * @param sticker_set_name         String	Optional. For supergroups, name of group sticker set. Returned only in getChat.
 * @param can_set_sticker_set      Boolean	Optional. True, if the bot can change the group sticker set. Returned only in getChat.
 * @param linked_chat_id           Integer	Optional. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. Returned only in getChat.
 * @param location                 ChatLocation	Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
 */
case class Chat(
  id                      : Long,
  `type`                  : ChatType,
  title                   : Option[String] = None,
  username                : Option[String] = None,
  first_name              : Option[String] = None,
  last_name               : Option[String] = None,
  photo                   : Option[ChatPhoto] = None,
  bio                     : Option[String] = None,
  description             : Option[String] = None,
  invite_link             : Option[String] = None,
  pinned_message          : Option[Message] = None,
  permissions             : Option[ChatPermissions] = None,
  slow_mode_delay         : Option[Int] = None,
  message_auto_delete_time: Option[Int] = None,
  sticker_set_name        : Option[String] = None,
  can_set_sticker_set     : Option[Boolean] = None,
  linked_chat_id          : Option[Int] = None,
  location                : Option[ChatLocation] = None
)