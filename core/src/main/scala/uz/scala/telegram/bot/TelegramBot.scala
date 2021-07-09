package uz.scala.telegram.bot

import uz.scala.telegram.bot.clients.ScalajHttpClient
import uz.scala.telegram.bot.models.Update

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * TelegramBot
 *
 * Base for Telegram Bots
 */
abstract class TelegramBot(val token: String) extends ScalajHttpClient(token) {

  /**
   * handleUpdate
   *
   * Process incoming updates (coming from polling, webhooks...)
   */
  def handleUpdate(update: Update): Unit
}
