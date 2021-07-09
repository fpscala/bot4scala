package samples

import uz.scala.telegram.bot.TelegramBot
import uz.scala.telegram.bot.methods.GetMe
import uz.scala.telegram.bot.marshalling.getMeEncoder

object AsyncBot extends TelegramBot("801181530:AAG7x1PH8IIKBmX0umPCES3RZpsxWtyyfGc") {
  sendRequest(GetMe)
}

object Bot extends App {
  AsyncBot.run()
}