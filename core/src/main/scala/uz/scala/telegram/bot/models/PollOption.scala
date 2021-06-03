package uz.scala.telegram.bot.models

/**
 * PollOption
 *
 * This object contains information about one answer option in a poll.
 *
 * @param text        String	Option text, 1-100 characters
 * @param voter_count Integer	Number of users that voted for this option
 */
case class PollOption(
  text       : String,
  voter_count: Int
)
