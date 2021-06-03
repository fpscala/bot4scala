package uz.scala.telegram.bot.models

/**
 * VoiceChatScheduled
 *
 * This object represents a service message about a voice chat scheduled in the chat.
 *
 * @param start_date	Integer	Point in time (Unix timestamp) when the voice chat is supposed to be started by a chat administrator
 * */

case class VoiceChatScheduled(start_date: Int)
