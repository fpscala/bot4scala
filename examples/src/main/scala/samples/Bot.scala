package samples

import uz.scala.telegram.bot.{Commands, Polling, TelegramBot}
import uz.scala.telegram.bot.api.InputFile

object AsyncBot extends TelegramBot("token") with Polling with Commands {
  // Send a photo aysnchronously
  onCommand("foto") { (sender, _) =>
    sendPhoto(sender, InputFile("./clock--v2.png"), caption = Some("💪!!!🦾"))
  }
}

object Bot extends App {
  AsyncBot.start()
}