package uz.scala.telegram.bot.models

/**
 * Message
 *
 * This object represents a message.
 *
 * @param message_id                        Integer	Unique message identifier inside this chat
 * @param from                              User	Optional. Sender, empty for messages sent to channels
 * @param sender_chat                       Chat	Optional. Sender of the message, sent on behalf of a chat. The channel itself for channel messages. The supergroup itself for messages from anonymous group administrators. The linked channel for messages automatically forwarded to the discussion group
 * @param date                              Integer	Date the message was sent in Unix time
 * @param chat                              Chat	Conversation the message belongs to
 * @param forward_from                      User	Optional. For forwarded messages, sender of the original message
 * @param forward_from_chat                 Chat	Optional. For messages forwarded from channels or from anonymous administrators, information about the original sender chat
 * @param forward_from_message_id           Integer	Optional. For messages forwarded from channels, identifier of the original message in the channel
 * @param forward_signature                 String	Optional. For messages forwarded from channels, signature of the post author if present
 * @param forward_sender_name               String	Optional. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
 * @param forward_date                      Integer	Optional. For forwarded messages, date the original message was sent in Unix time
 * @param reply_to_message                  Message	Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
 * @param via_bot                           User	Optional. Bot through which the message was sent
 * @param edit_date                         Integer	Optional. Date the message was last edited in Unix time
 * @param media_group_id                    String	Optional. The unique identifier of a media message group this message belongs to
 * @param author_signature                  String	Optional. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
 * @param text                              String	Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters
 * @param entities                          Array of MessageEntity	Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @param animation                         Animation	Optional. Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set
 * @param audio                             Audio	Optional. Message is an audio file, information about the file
 * @param document                          Document	Optional. Message is a general file, information about the file
 * @param photo                             Array of PhotoSize	Optional. Message is a photo, available sizes of the photo
 * @param sticker                           Sticker	Optional. Message is a sticker, information about the sticker
 * @param video                             Video	Optional. Message is a video, information about the video
 * @param video_note                        VideoNote	Optional. Message is a video note, information about the video message
 * @param voice                             Voice	Optional. Message is a voice message, information about the file
 * @param caption                           String	Optional. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
 * @param caption_entities                  Array of MessageEntity	Optional. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @param contact                           Contact	Optional. Message is a shared contact, information about the contact
 * @param dice                              Dice	Optional. Message is a dice with random value
 * @param game                              Game	Optional. Message is a game, information about the game. More about games »
 * @param poll                              Poll	Optional. Message is a native poll, information about the poll
 * @param venue                             Venue	Optional. Message is a venue, information about the venue. For backward compatibility, when this field is set, the location field will also be set
 * @param location                          Location	Optional. Message is a shared location, information about the location
 * @param new_chat_members                  Array of User	Optional. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
 * @param left_chat_member                  User	Optional. A member was removed from the group, information about them (this member may be the bot itself)
 * @param new_chat_title                    String	Optional. A chat title was changed to this value
 * @param new_chat_photo                    Array of PhotoSize	Optional. A chat photo was change to this value
 * @param delete_chat_photo                 True	Optional. Service message: the chat photo was deleted
 * @param group_chat_created                True	Optional. Service message: the group has been created
 * @param supergroup_chat_created           True	Optional. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
 * @param channel_chat_created              True	Optional. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
 * @param message_auto_delete_timer_changed MessageAutoDeleteTimerChanged	Optional. Service message: auto-delete timer settings changed in the chat
 * @param migrate_to_chat_id                Integer	Optional. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @param migrate_from_chat_id              Integer	Optional. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @param pinned_message                    Message	Optional. Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
 * @param invoice                           Invoice	Optional. Message is an invoice for a payment, information about the invoice. More about payments »
 * @param successful_payment                SuccessfulPayment	Optional. Message is a service message about a successful payment, information about the payment. More about payments »
 * @param connected_website                 String	Optional. The domain name of the website on which the user has logged in. More about Telegram Login »
 * @param passport_data                     PassportData	Optional. Telegram Passport data
 * @param proximity_alert_triggered         ProximityAlertTriggered	Optional. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
 * @param voice_chat_scheduled              VoiceChatScheduled	Optional. Service message: voice chat scheduled
 * @param voice_chat_started                VoiceChatStarted	Optional. Service message: voice chat started
 * @param voice_chat_ended                  VoiceChatEnded	Optional. Service message: voice chat ended
 * @param voice_chat_participants_invited   VoiceChatParticipantsInvited	Optional. Service message: new participants invited to a voice chat
 * @param reply_markup                      InlineKeyboardMarkup	Optional. Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.
 * */
case class Message(
  message_id                           : Int,
  chat                                 : Chat,
  date                                 : Int,
  sender_chat                          : Option[Chat],
  from                                 : Option[User],
  forward_from                         : Option[User] = None,
  forward_from_chat                    : Option[Chat] = None,
  forward_from_message_id              : Option[Int] = None,
  forward_signature                    : Option[String] = None,
  forward_sender_name                  : Option[String] = None,
  forward_date                         : Option[Int] = None,
  reply_to_message                     : Option[Message] = None,
  via_bot                              : Option[User] = None,
  edit_date                            : Option[Int] = None,
  media_group_id                       : Option[String] = None,
  author_signature                     : Option[String] = None,
  text                                 : Option[String] = None,
  entities                             : Option[MessageEntity] = None,
  animation                            : Option[Animation] = None,
  audio                                : Option[Audio] = None,
  document                             : Option[Document] = None,
  photo                                : Option[Array[PhotoSize]] = None,
  sticker                              : Option[Sticker] = None,
  video                                : Option[Video] = None,
  video_note                           : Option[VideoNote] = None,
  voice                                : Option[Voice] = None,
  caption                              : Option[String] = None,
  caption_entities                     : Option[MessageEntity] = None,
  contact                              : Option[Contact] = None,
  dice                                 : Option[Dice] = None,
  game                                 : Option[Game] = None,
  poll                                 : Option[Poll] = None,
  venue                                : Option[Venue] = None,
  location                             : Option[Location] = None,
  new_chat_members                     : Option[Array[User]] = None,
  left_chat_member                     : Option[User] = None,
  new_chat_title                       : Option[String] = None,
  new_chat_photo                       : Option[Array[PhotoSize]] = None,
  delete_chat_photo                    : Option[Boolean] = None,
  group_chat_created                   : Option[Boolean] = None,
  supergroup_chat_created              : Option[Boolean] = None,
  channel_chat_created                 : Option[Boolean] = None,
  message_auto_delete_timer_changed    : Option[MessageAutoDeleteTimerChanged] = None,
  migrate_to_chat_id                   : Option[Int] = None,
  migrate_from_chat_id                 : Option[Int] = None,
  pinned_message                       : Option[Message] = None,
  invoice                              : Option[Invoice] = None,
  successful_payment                   : Option[SuccessfulPayment] = None,
  connected_website                    : Option[String] = None,
  passport_data                        : Option[PassportData] = None,
  proximity_alert_triggered            : Option[ProximityAlertTriggered] = None,
  voice_chat_scheduled                 : Option[VoiceChatScheduled] = None,
  voice_chat_started                   : Option[VoiceChatStarted] = None,
  voice_chat_ended                     : Option[VoiceChatEnded] = None,
  voice_chat_participants_invited      : Option[VoiceChatParticipantsInvited] = None,
  reply_markup                         : Option[InlineKeyboardMarkup] = None,
)
