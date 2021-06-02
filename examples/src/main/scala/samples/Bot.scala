package samples

import org.prince.telegram.bot.api.InputFile
import org.prince.telegram.bot.{Commands, Polling, TelegramBot}

object AsyncBot extends TelegramBot("801181530:AAHewjnuAhU40jYF_k0G5rtbuWg9WfbR4_A") with Polling with Commands {
  // Send a photo aysnchronously
  onCommand("foto") { (sender, _) =>
    sendPhoto(sender, InputFile("./clock--v2.png"), caption = Some("Bender the great!!!"))
  }
}

object Bot extends App {
  AsyncBot.run()
}