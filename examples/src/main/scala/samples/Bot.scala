package samples

import uz.scala.telegram.bot.{Commands, TelegramBot}
import uz.scala.telegram.bot.models.InputFile

object AsyncBot extends TelegramBot("801181530:AAG7x1PH8IIKBmX0umPCES3RZpsxWtyyfGc") with Polling with Commands {
  // Send a photo aysnchronously
  onCommand("foto") { (sender, _) =>
    println(sender)
    sendPhoto(sender, InputFile("./image.png"), caption = Some("💪!!!🦾"))
  }
}

object Bot extends App {
  AsyncBot.run()
}