package uz.scala.telegram.bot.models

/**
 * Poll
 *
 * This object contains information about a poll.
 *
 * @param id                      String	Unique poll identifier
 * @param type                    String	Poll type, currently can be “regular” or “quiz”
 * @param question                String	Poll question, 1-300 characters
 * @param options                 Array of PollOption	List of poll options
 * @param total_voter_count       Integer	Total number of users that voted in the poll
 * @param is_closed               Boolean	True, if the poll is closed
 * @param is_anonymous            Boolean	True, if the poll is anonymous
 * @param allows_multiple_answers Boolean	True, if the poll allows multiple answers
 * @param correct_option_id       Integer	Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
 * @param explanation             String	Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
 * @param explanation_entities    Array of MessageEntity	Optional. Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
 * @param open_period             Integer	Optional. Amount of time in seconds the poll will be active after creation
 * @param close_date              Integer	Optional. Point in time (Unix timestamp) when the poll will be automatically closed
 * */

case class Poll(
  id: String,
  `type`: Boolean,
  question: String,
  options : Array[PollOption],
  total_voter_count: Int,
  is_closed: Boolean,
  is_anonymous: Boolean,
  allows_multiple_answers: Boolean,
  correct_option_id: Option[Int] = None,
  explanation: Option[String] = None,
  explanation_entities: Option[Array[MessageEntity]] = None,
  open_period: Option[Int] = None,
  close_date: Option[Int] = None
)
