package uz.scala.telegram.bot.models
/**
 * Dice
 * This object represents an animated emoji that displays a random value.
 *
 * @param emoji	String	Emoji on which the dice throw animation is based
 * @param value	Integer	Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji, 1-64 for “🎰” base emoji
 */
case class Dice(
  emoji: String,
  value: Int
)
