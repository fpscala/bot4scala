package uz.scala.telegram.bot.models

/**
 * VoiceChatParticipantsInvited
 *
 * This object represents a service message about new members invited to a voice chat.
 *
 * @param users	Array of User	Optional. New members that were invited to the voice chat
 *
 * */
case class VoiceChatParticipantsInvited(users: Option[Array[User]] = None)
