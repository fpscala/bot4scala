package uz.scala.telegram.bot.models
/**
 * MessageAutoDeleteTimerChanged
 *
 * This object represents a service message about a change in auto-delete timer settings.
 *
 * @param message_auto_delete_time	Integer	New auto-delete time for messages in the chat
 * */
case class MessageAutoDeleteTimerChanged(message_auto_delete_time: Int)
