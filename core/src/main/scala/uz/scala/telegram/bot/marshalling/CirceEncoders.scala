package uz.scala.telegram.bot.marshalling

import io.circe.Encoder
import io.circe.generic.extras._
import io.circe.generic.extras.auto._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import uz.scala.telegram.bot.methods.ParseMode.ParseMode
import uz.scala.telegram.bot.methods.PollType.PollType
import uz.scala.telegram.bot.methods.{GetMe, GetUpdates}
import uz.scala.telegram.bot.models.ChatAction.ChatAction
import uz.scala.telegram.bot.models.ChatType.ChatType
import uz.scala.telegram.bot.models.CountryCode.CountryCode
import uz.scala.telegram.bot.models.Currency.{Currency, TelegramCurrency}
import uz.scala.telegram.bot.models.MaskPositionType.MaskPositionType
import uz.scala.telegram.bot.models.MemberStatus.MemberStatus
import uz.scala.telegram.bot.models.MessageEntityType.MessageEntityType
import uz.scala.telegram.bot.models._

/**
 * Circe marshalling borrowed/inspired from [[https://github.com/nikdon/telepooz]]
 */
trait CirceEncoders {

  implicit val customConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

  // Models
  implicit val audioEncoder        : Encoder[Audio]         = deriveConfiguredEncoder[Audio]
  implicit val callbackQueryEncoder: Encoder[CallbackQuery] = deriveConfiguredEncoder[CallbackQuery]

  implicit val callbackGameEncoder: Encoder[CallbackGame] = deriveConfiguredEncoder[CallbackGame]

  implicit val chatTypeEncoder: Encoder[ChatType] =
    Encoder[String].contramap[ChatType](e => CaseConversions.snakenize(e.toString))

  implicit val chatEncoder: Encoder[Chat] = deriveConfiguredEncoder[Chat]

  implicit val chatMemberEncoder: Encoder[ChatMember] = deriveConfiguredEncoder[ChatMember]

  implicit val contactEncoder : Encoder[Contact]  = deriveConfiguredEncoder[Contact]
  implicit val documentEncoder: Encoder[Document] = deriveConfiguredEncoder[Document]
  implicit val fileEncoder    : Encoder[File]     = deriveConfiguredEncoder[File]

  implicit val inlineKeyboardButtonEncoder: Encoder[InlineKeyboardButton] =
    deriveConfiguredEncoder[InlineKeyboardButton]
  implicit val keyboardButtonEncoder      : Encoder[KeyboardButton]       = deriveConfiguredEncoder[KeyboardButton]
  implicit val locationEncoder            : Encoder[Location]             = deriveConfiguredEncoder[Location]

  implicit val gameHighScoreEncoder: Encoder[GameHighScore] = deriveConfiguredEncoder[GameHighScore]
  implicit val animationEncoder    : Encoder[Animation]     = deriveConfiguredEncoder[Animation]
  implicit val gameEncoder         : Encoder[Game]          = deriveConfiguredEncoder[Game]

  implicit val messageEncoder: Encoder[Message] = deriveConfiguredEncoder[Message]

  implicit val messageEntityTypeEncoder: Encoder[MessageEntityType] =
    Encoder[String].contramap[MessageEntityType](e => CaseConversions.snakenize(e.toString))

  implicit val messageEntityEncoder: Encoder[MessageEntity] = deriveConfiguredEncoder[MessageEntity]

  implicit val parseModeEncoder: Encoder[ParseMode] =
    Encoder[String].contramap[ParseMode](e => CaseConversions.snakenize(e.toString))

  implicit val pollTypeEncoder: Encoder[PollType] =
    Encoder[String].contramap[PollType](e => CaseConversions.snakenize(e.toString))

  implicit val photoSizeEncoder: Encoder[PhotoSize] = deriveConfiguredEncoder[PhotoSize]

  implicit val memberStatusEncoder: Encoder[MemberStatus] =
    Encoder[String].contramap(e => CaseConversions.snakenize(e.toString))

  implicit val replyMarkupEncoder: Encoder[ReplyMarkup] = Encoder.instance {
    case fr: ForceReply            => fr.asJson
    case ikm: InlineKeyboardMarkup => ikm.asJson
    case rkm: ReplyKeyboardMarkup  => rkm.asJson
  }

  implicit val stickerEncoder     : Encoder[Sticker]      = deriveConfiguredEncoder[Sticker]
  implicit val maskPositionEncoder: Encoder[MaskPosition] = deriveConfiguredEncoder[MaskPosition]

  implicit val userEncoder             : Encoder[User]              = deriveConfiguredEncoder[User]
  implicit val userProfilePhotosEncoder: Encoder[UserProfilePhotos] = deriveConfiguredEncoder[UserProfilePhotos]
  implicit val venueEncoder            : Encoder[Venue]             = deriveConfiguredEncoder[Venue]
  implicit val videoEncoder            : Encoder[Video]             = deriveConfiguredEncoder[Video]
  implicit val videoNoteEncoder        : Encoder[VideoNote]         = deriveConfiguredEncoder[VideoNote]
  implicit val voiceEncoder            : Encoder[Voice]             = deriveConfiguredEncoder[Voice]

  implicit val loginUrlEncoder: Encoder[LoginUrl] = deriveConfiguredEncoder[LoginUrl]

  // Payments
  implicit val currencyEncoder         : Encoder[Currency]          =
    Encoder[String].contramap(c => c.asInstanceOf[TelegramCurrency].code)
  implicit val labeledPriceEncoder     : Encoder[LabeledPrice]      = deriveConfiguredEncoder[LabeledPrice]
  implicit val invoiceEncoder          : Encoder[Invoice]           = deriveConfiguredEncoder[Invoice]
  implicit val shippingAddressEncoder  : Encoder[ShippingAddress]   = deriveConfiguredEncoder[ShippingAddress]
  implicit val shippingQueryEncoder    : Encoder[ShippingQuery]     = deriveConfiguredEncoder[ShippingQuery]
  implicit val orderInfoEncoder        : Encoder[OrderInfo]         = deriveConfiguredEncoder[OrderInfo]
  implicit val preCheckoutQueryEncoder : Encoder[PreCheckoutQuery]  = deriveConfiguredEncoder[PreCheckoutQuery]
  implicit val shippingOptionEncoder   : Encoder[ShippingOption]    = deriveConfiguredEncoder[ShippingOption]
  implicit val successfulPaymentEncoder: Encoder[SuccessfulPayment] = deriveConfiguredEncoder[SuccessfulPayment]
  implicit val countryCodeEncoder      : Encoder[CountryCode]       =
    Encoder[String].contramap(c => CaseConversions.snakenize(c.toString))

  implicit val updateEncoder: Encoder[Update] = deriveConfiguredEncoder[Update]

  // Inline
  implicit val inlineQueryEncoder      : Encoder[InlineQuery]        = deriveConfiguredEncoder[InlineQuery]
  implicit val chosenInlineQueryEncoder: Encoder[ChosenInlineResult] = deriveConfiguredEncoder[ChosenInlineResult]

  implicit val inputContactMessageContentEncoder : Encoder[InputContactMessageContent]  =
    deriveConfiguredEncoder[InputContactMessageContent]
  implicit val inputVenueMessageContent          : Encoder[InputVenueMessageContent]    =
    deriveConfiguredEncoder[InputVenueMessageContent]
  implicit val inputLocationMessageContentEncoder: Encoder[InputLocationMessageContent] =
    deriveConfiguredEncoder[InputLocationMessageContent]
  implicit val inputTextMessageContentEncoder    : Encoder[InputTextMessageContent]     =
    deriveConfiguredEncoder[InputTextMessageContent]

  implicit val inputMessageContentEncoder: Encoder[InputMessageContent] = Encoder.instance {
    case q: InputTextMessageContent     => q.asJson
    case q: InputLocationMessageContent => q.asJson
    case q: InputVenueMessageContent    => q.asJson
    case q: InputContactMessageContent  => q.asJson
  }

  /** InlineQueryResult */
  implicit val inlineQueryResultArticleEncoder : Encoder[InlineQueryResultArticle]  =
    deriveConfiguredEncoder[InlineQueryResultArticle]
  implicit val inlineQueryResultPhotoEncoder   : Encoder[InlineQueryResultPhoto]    =
    deriveConfiguredEncoder[InlineQueryResultPhoto]
  implicit val inlineQueryResultGifEncoder     : Encoder[InlineQueryResultGif]      =
    deriveConfiguredEncoder[InlineQueryResultGif]
  implicit val inlineQueryResultMpeg4GifEncoder: Encoder[InlineQueryResultMpeg4Gif] =
    deriveConfiguredEncoder[InlineQueryResultMpeg4Gif]

  implicit val inlineQueryResultVideoEncoder: Encoder[InlineQueryResultVideo] =
    deriveConfiguredEncoder[InlineQueryResultVideo]

  implicit val inlineQueryResultAudioEncoder: Encoder[InlineQueryResultAudio] =
    deriveConfiguredEncoder[InlineQueryResultAudio]

  implicit val inlineQueryResultVoiceEncoder: Encoder[InlineQueryResultVoice] =
    deriveConfiguredEncoder[InlineQueryResultVoice]

  implicit val inlineQueryResultDocumentEncoder: Encoder[InlineQueryResultDocument] =
    deriveConfiguredEncoder[InlineQueryResultDocument]

  implicit val inlineQueryResultLocationEncoder: Encoder[InlineQueryResultLocation] =
    deriveConfiguredEncoder[InlineQueryResultLocation]

  implicit val inlineQueryResultVenueEncoder: Encoder[InlineQueryResultVenue] =
    deriveConfiguredEncoder[InlineQueryResultVenue]

  implicit val inlineQueryResultContactEncoder: Encoder[InlineQueryResultContact] =
    deriveConfiguredEncoder[InlineQueryResultContact]

  implicit val inlineQueryResultCachedPhotoEncoder: Encoder[InlineQueryResultCachedPhoto] =
    deriveConfiguredEncoder[InlineQueryResultCachedPhoto]

  implicit val inlineQueryResultCachedGifEncoder: Encoder[InlineQueryResultCachedGif] =
    deriveConfiguredEncoder[InlineQueryResultCachedGif]

  implicit val inlineQueryResultCachedMpeg4GifEncoder: Encoder[InlineQueryResultCachedMpeg4Gif] =
    deriveConfiguredEncoder[InlineQueryResultCachedMpeg4Gif]

  implicit val inlineQueryResultCachedStickerEncoder: Encoder[InlineQueryResultCachedSticker] =
    deriveConfiguredEncoder[InlineQueryResultCachedSticker]

  implicit val inlineQueryResultCachedDocumentEncoder: Encoder[InlineQueryResultCachedDocument] =
    deriveConfiguredEncoder[InlineQueryResultCachedDocument]

  implicit val inlineQueryResultCachedVideoEncoder: Encoder[InlineQueryResultCachedVideo] =
    deriveConfiguredEncoder[InlineQueryResultCachedVideo]

  implicit val inlineQueryResultCachedVoiceEncoder: Encoder[InlineQueryResultCachedVoice] =
    deriveConfiguredEncoder[InlineQueryResultCachedVoice]

  implicit val inlineQueryResultCachedAudioEncoder: Encoder[InlineQueryResultCachedAudio] =
    deriveConfiguredEncoder[InlineQueryResultCachedAudio]

  implicit val inlineQueryResultGameEncoder: Encoder[InlineQueryResultGame] =
    deriveConfiguredEncoder[InlineQueryResultGame]

  implicit val inlineQueryResultEncoder: Encoder[InlineQueryResult] = Encoder.instance {
    case q: InlineQueryResultCachedAudio    => q.asJson
    case q: InlineQueryResultCachedDocument => q.asJson
    case q: InlineQueryResultCachedGif      => q.asJson
    case q: InlineQueryResultCachedMpeg4Gif => q.asJson
    case q: InlineQueryResultCachedPhoto    => q.asJson
    case q: InlineQueryResultCachedSticker  => q.asJson
    case q: InlineQueryResultCachedVideo    => q.asJson
    case q: InlineQueryResultCachedVoice    => q.asJson
    case q: InlineQueryResultArticle        => q.asJson
    case q: InlineQueryResultAudio          => q.asJson
    case q: InlineQueryResultContact        => q.asJson
    case q: InlineQueryResultDocument       => q.asJson
    case q: InlineQueryResultGif            => q.asJson
    case q: InlineQueryResultLocation       => q.asJson
    case q: InlineQueryResultMpeg4Gif       => q.asJson
    case q: InlineQueryResultPhoto          => q.asJson
    case q: InlineQueryResultVenue          => q.asJson
    case q: InlineQueryResultVideo          => q.asJson
    case q: InlineQueryResultVoice          => q.asJson
    case q: InlineQueryResultGame           => q.asJson
  }

  // Methods
  implicit val getMeEncoder     : Encoder[GetMe.type] = Encoder.instance(_ => io.circe.Json.Null)
  implicit val getUpdatesEncoder: Encoder[GetUpdates] = deriveConfiguredEncoder[GetUpdates]

  // for v5.1 support
  implicit val chatInviteLinkEncoder   : Encoder[ChatInviteLink]    = deriveConfiguredEncoder[ChatInviteLink]
  implicit val chatMemberUpdatedEncoder: Encoder[ChatMemberUpdated] = deriveConfiguredEncoder[ChatMemberUpdated]

  // Ignore InputFiles as JSON.
  implicit def inputFileEncoder: Encoder[InputFile] = Encoder.instance(_ => io.circe.Json.Null)

  implicit val chatIdEncoder: Encoder[ChatId] = Encoder.instance {
    case ChatId.Chat(chat)       => chat.asJson
    case ChatId.Channel(channel) => channel.asJson
  }

  implicit val chatActionEncoder: Encoder[ChatAction] =
    Encoder[String].contramap[ChatAction](e => CaseConversions.snakenize(e.toString))

  implicit val maskPositionTypeEncoder: Encoder[MaskPositionType] =
    Encoder[String].contramap[MaskPositionType](e => CaseConversions.snakenize(e.toString))
}

object CirceEncoders extends CirceEncoders
