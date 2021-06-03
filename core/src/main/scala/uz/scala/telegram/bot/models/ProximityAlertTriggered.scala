package uz.scala.telegram.bot.models

/**
 * ProximityAlertTriggered
 *
 * This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.
 *
 * @param traveler User	User that triggered the alert
 * @param watcher  User	User that set the alert
 * @param distance Integer	The distance between the users@param
 * */

case class ProximityAlertTriggered(
  traveler: User,
  watcher: User,
  distance: Int
)