package samples

import uz.scala.telegram.bot.OptionPimps._
import uz.scala.telegram.bot.{Commands, Polling, TelegramBot, Utils}
import uz.scala.telegram.bot.api.{ForceReply, InputFile, ReplyKeyboardHide, ReplyKeyboardMarkup}

import java.net.URLEncoder

object FlunkeyBot extends TelegramBot(Utils.tokenFromFile("./tokens/flunkeybot.token")) with Polling with Commands {

  onCommand("hello") { (sender, _) =>
    replyTo(sender) {
      "Hello World!"
    }
  }

  onCommand("echo") { (sender, args) => {
    replyTo(sender) {
      args mkString " "
    }
  }
  }

  // Let Me Google That For You :)
  onCommand("lmgtfy") { (sender, args) =>
    replyTo(sender, disableWebPagePreview = true) {
      "http://lmgtfy.com/?q=" + URLEncoder.encode(args mkString " ", "UTF-8")
    }
  }

  onCommand("start") { (sender, _) =>
    replyTo(sender) {
      """/hello - says hello to the world!!!
        |/lmgtfy query - sends a LMGTFY URL !!
        |/echo args - simple echo
        |/photo - sends a picture of me!!!
      """.stripMargin
    }
  }

  onCommand("video") { (sender, _) =>
    sendVideo(sender, InputFile("./files/video.mp4"),
              caption = "Sample video")
  }

  onCommand("audio") { (sender, _) =>
    sendAudio(sender, InputFile("./files/audio.mp3"))
  }

  onCommand("photo") { (sender, _) =>
    sendPhoto(sender, InputFile("./files/photo.jpg"),
              caption = "Bender the great!")
  }

  onCommand("sticker") { (sender, _) =>
    sendSticker(sender, stickerFile = InputFile("./files/sticker.png"))
  }

  onCommand("document") { (sender, _) =>
    sendDocument(sender, documentFile = InputFile("./files/document.pdf"))
  }

  onCommand("markup") { (sender, _) =>
    val kb: Array[Array[String]] = Array(Array("Sucks!", "Sucks^2!"))
    val markup                   = ReplyKeyboardMarkup(kb,
                                                       resizeKeyboard = true,
                                                       oneTimeKeyboard = false)

    sendMessage(sender, "Bieber?", replyMarkup = markup)
  }

  onCommand("hide") { (sender, _) =>
    val markup = ReplyKeyboardHide(hideKeyboard = true)
    sendMessage(sender, "Bla bla bla...", replyMarkup = markup)
  }

  onCommand("forcereply") { (sender, _) =>
    val markup = ForceReply(forceReply = true)
    sendMessage(sender, "Bla bla bla...", replyMarkup = markup)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    FlunkeyBot.run()
  }
}
