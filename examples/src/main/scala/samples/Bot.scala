package samples

import uz.scala.telegram.bot.{Commands, Polling, TelegramBot}
import uz.scala.telegram.bot.models.InputFile

object AsyncBot extends TelegramBot("801181530:AAHewjnuAhU40jYF_k0G5rtbuWg9WfbR4_A") with Polling with Commands {
  // Send a photo aysnchronously
  onCommand("foto") { (_, _) =>
    sendPhoto(-1001397860592L, InputFile("./image.jpeg"), caption = Some("💪!!!🦾"))
  }
}

object Bot extends App {
  AsyncBot.run()
}