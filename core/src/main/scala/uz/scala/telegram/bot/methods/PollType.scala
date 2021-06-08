package uz.scala.telegram.bot.methods

import uz.scala.telegram.bot.methods

/**
 * Represent a type of poll
 */
object PollType extends Enumeration {
  type PollType = Value
  val regular: methods.PollType.Value = Value("regular")
  val quiz   : methods.PollType.Value = Value("quiz")
}
