package uz.scala.telegram.bot.methods

import uz.scala.telegram.bot.models.User

/**
 * A simple method for testing your bot's auth token. Requires no parameters.
 * Returns basic information about the bot in form of a User object.
 */
case object GetMe extends JsonRequest[User]
