package uz.scala.telegram.bot.models

/**
 * Message
 *
 * This object represents a message.
 *
 * @param messageId                     Integer	Unique message identifier inside this chat
 * @param from                          User	Optional. Sender, empty for messages sent to channels
 * @param senderChat                    Chat	Optional. Sender of the message, sent on behalf of a chat. The channel itself for channel messages. The supergroup itself for messages from anonymous group administrators. The linked channel for messages automatically forwarded to the discussion group
 * @param date                          Integer	Date the message was sent in Unix time
 * @param chat                          Chat	Conversation the message belongs to
 * @param forwardFrom                   User	Optional. For forwarded messages, sender of the original message
 * @param forwardFromChat               Chat	Optional. For messages forwarded from channels or from anonymous administrators, information about the original sender chat
 * @param forwardFromMessageId          Integer	Optional. For messages forwarded from channels, identifier of the original message in the channel
 * @param forwardSignature              String	Optional. For messages forwarded from channels, signature of the post author if present
 * @param forwardSenderName             String	Optional. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
 * @param forwardDate                   Integer	Optional. For forwarded messages, date the original message was sent in Unix time
 * @param replyToMessage                Message	Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
 * @param viaBot                        User	Optional. Bot through which the message was sent
 * @param editDate                      Integer	Optional. Date the message was last edited in Unix time
 * @param mediaGroupId                  String	Optional. The unique identifier of a media message group this message belongs to
 * @param authorSignature               String	Optional. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
 * @param text                          String	Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters
 * @param entities                      Array of MessageEntity	Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @param animation                     Animation	Optional. Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set
 * @param audio                         Audio	Optional. Message is an audio file, information about the file
 * @param document                      Document	Optional. Message is a general file, information about the file
 * @param photo                         Array of PhotoSize	Optional. Message is a photo, available sizes of the photo
 * @param sticker                       Sticker	Optional. Message is a sticker, information about the sticker
 * @param video                         Video	Optional. Message is a video, information about the video
 * @param videoNote                     VideoNote	Optional. Message is a video note, information about the video message
 * @param voice                         Voice	Optional. Message is a voice message, information about the file
 * @param caption                       String	Optional. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
 * @param captionEntities               Array of MessageEntity	Optional. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @param contact                       Contact	Optional. Message is a shared contact, information about the contact
 * @param dice                          Dice	Optional. Message is a dice with random value
 * @param game                          Game	Optional. Message is a game, information about the game. More about games »
 * @param poll                          Poll	Optional. Message is a native poll, information about the poll
 * @param venue                         Venue	Optional. Message is a venue, information about the venue. For backward compatibility, when this field is set, the location field will also be set
 * @param location                      Location	Optional. Message is a shared location, information about the location
 * @param newChatMembers                Array of User	Optional. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
 * @param leftChatMember                User	Optional. A member was removed from the group, information about them (this member may be the bot itself)
 * @param newChatTitle                  String	Optional. A chat title was changed to this value
 * @param newChatPhoto                  Array of PhotoSize	Optional. A chat photo was change to this value
 * @param deleteChatPhoto               True	Optional. Service message: the chat photo was deleted
 * @param groupChatCreated              True	Optional. Service message: the group has been created
 * @param supergroupChatCreated         True	Optional. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
 * @param channelChatCreated            True	Optional. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
 * @param messageAutoDeleteTimerChanged MessageAutoDeleteTimerChanged	Optional. Service message: auto-delete timer settings changed in the chat
 * @param migrateToChatId               Integer	Optional. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @param migrateFromChatId             Integer	Optional. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @param pinnedMessage                 Message	Optional. Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
 * @param invoice                       Invoice	Optional. Message is an invoice for a payment, information about the invoice. More about payments »
 * @param successfulPayment             SuccessfulPayment	Optional. Message is a service message about a successful payment, information about the payment. More about payments »
 * @param connectedWebsite              String	Optional. The domain name of the website on which the user has logged in. More about Telegram Login »
 * @param passportData                  PassportData	Optional. Telegram Passport data
 * @param proximityAlertTriggered       ProximityAlertTriggered	Optional. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
 * @param voiceChatScheduled            VoiceChatScheduled	Optional. Service message: voice chat scheduled
 * @param voiceChatStarted              VoiceChatStarted	Optional. Service message: voice chat started
 * @param voiceChatEnded                VoiceChatEnded	Optional. Service message: voice chat ended
 * @param voiceChatParticipantsInvited  VoiceChatParticipantsInvited	Optional. Service message: new participants invited to a voice chat
 * @param replyMarkup                   InlineKeyboardMarkup	Optional. Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.
 * */
case class Message(
  messageId: Int,
  chat: Chat,
  date: Int,
  senderChat: Option[Chat],
  from: Option[User],
  forwardFrom: Option[User] = None,
  forwardFromChat: Option[Chat] = None,
  forwardFromMessageId: Option[Int] = None,
  forwardSignature: Option[String] = None,
  forwardSenderName: Option[String] = None,
  forwardDate: Option[Int] = None,
  replyToMessage: Option[Message] = None,
  viaBot: Option[User] = None,
  editDate: Option[Int] = None,
  mediaGroupId: Option[String] = None,
  authorSignature: Option[String] = None,
  text: Option[String] = None,
  entities: Option[MessageEntity] = None,
  animation: Option[Animation] = None,
  audio: Option[Audio] = None,
  document: Option[Document] = None,
  photo: Option[Array[PhotoSize]] = None,
  sticker: Option[Sticker] = None,
  video: Option[Video] = None,
  videoNote: Option[VideoNote] = None,
  voice: Option[Voice] = None,
  caption: Option[String] = None,
  captionEntities: Option[MessageEntity] = None,
  contact: Option[Contact] = None,
  dice: Option[Dice] = None,
  game: Option[Game] = None,
  poll: Option[Poll] = None,
  venue: Option[Venue] = None,
  location: Option[Location] = None,
  newChatMembers: Option[Array[User]] = None,
  leftChatMember: Option[User] = None,
  newChatTitle: Option[String] = None,
  newChatPhoto: Option[Array[PhotoSize]] = None,
  deleteChatPhoto: Option[Boolean] = None,
  groupChatCreated: Option[Boolean] = None,
  supergroupChatCreated: Option[Boolean] = None,
  channelChatCreated: Option[Boolean] = None,
  messageAutoDeleteTimerChanged: Option[MessageAutoDeleteTimerChanged] = None,
  migrateToChatId: Option[Int] = None,
  migrateFromChatId: Option[Int] = None,
  pinnedMessage: Option[Message] = None,
  invoice: Option[Invoice] = None,
  successfulPayment: Option[SuccessfulPayment] = None,
  connectedWebsite: Option[String] = None,
  passportData: Option[PassportData] = None,
  proximityAlertTriggered: Option[ProximityAlertTriggered] = None,
  voiceChatScheduled: Option[VoiceChatScheduled] = None,
  voiceChatStarted: Option[VoiceChatStarted] = None,
  voiceChatEnded: Option[VoiceChatEnded] = None,
  voiceChatParticipantsInvited: Option[VoiceChatParticipantsInvited] = None,
  replyMarkup: Option[InlineKeyboardMarkup] = None,
)
