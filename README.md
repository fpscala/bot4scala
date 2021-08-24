# Bot4scala
[![Build Status](https://travis-ci.com/Prince951-17/bot4scala.svg?branch=master)](https://travis-ci.com/Prince951-17/bot4scala)

Telegram Bot API for Scala
## As SBT dependency
Add to your `build.sbt` file:
```scala
libraryDependencies += "uz.scala" %% "bot4scala" % "1.0.7"
```

## Supported API:
  - getMe
  - sendMessage
  - getUpdates (polling)
  - forwardMessage
  - sendPhoto
  - sendAudio
  - sendVoice
  - sendDocument
  - sendSticker
  - sendVideo
  - sendLocation
  - sendChatAction
  - getUserProfilePhotos
  - getUpdates
  - setWebhooks
  - Custom keyboard markups
  - Self-signed certificates

## Contributions
Contributions are highly appreciated, documentation improvements/corrections, [better ways to do things](https://github.com/mukel/telegrambot4s/pull/1/files). Writing a bot using this library is also a way to contribute, I'll add a link to your bot here in README anytime.

# Usage

```scala

  val helloBot = new TelegramBot(TOKEN) with Polling with Commands
  
  helloBot.onCommand("hello") { (sender, args) =>
    replyTo(sender) {
      "Hello World!"
    }
  }
  
  helloBot.run()
  
```

Or Async bot

```scala

object AsyncBot extends TelegramBot(TOKEN) with Polling with Commands {
  
  onCommand("foto") { (sender, _) =>
    sendPhoto(sender, InputFile("./clock--v2.png"), caption = Some("💪!!!🦾"))
  }

  // Send a photo aysnchronously
  onCommand("bender") { (sender, _) =>
    Future {
      sendPhoto(sender, InputFile("./bender_photo.jpg"),
                caption = "Bender the great!!!")
    }
  }
}

AsyncBot.run()

```



