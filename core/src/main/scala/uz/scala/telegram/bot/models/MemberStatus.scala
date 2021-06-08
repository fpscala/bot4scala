package uz.scala.telegram.bot.models

object MemberStatus extends Enumeration {
  type MemberStatus = Value
  val Creator, Administrator, Member, Left, Kicked = Value
}
