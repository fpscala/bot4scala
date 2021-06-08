package uz.scala.telegram.bot

import uz.scala.telegram.bot.clients.ScalajHttpClient
import uz.scala.telegram.bot.models.Update

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

/**
 * TelegramBot
 *
 * Base for Telegram Bots
 */
abstract class TelegramBot(val token: String) extends ScalajHttpClient(token) {

  lazy val botName: String = Await.result(getMe.map(_.username.get), 5.seconds)

  /**
   * handleUpdate
   *
   * Process incoming updates (comming from polling, webhooks...)
   */
  def handleUpdate(update: Update): Unit
}
