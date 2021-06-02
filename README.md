# Bot4scala
[![Build Status](https://travis-ci.com/Prince951-17/bot4scala.svg?branch=master)](https://travis-ci.com/Prince951-17/bot4scala)

Telegram Bot API for Scala

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
  
  helloBot.on("hello") { (sender, args) =>
    replyTo(sender) {
      "Hello World!"
    }
  }
  
  helloBot.run()
  
```

Or Async bot

```scala

object AsyncBot extends TelegramBot(TOKEN) with Polling with Commands {

  on("expensive_computation") { (sender, args) =>
    Future {
      replyTo(sender) {
        // Expensive computation here
        Thread.sleep(10000)
        "42"
      }
    }
  }

  // Send a photo aysnchronously
  on("bender") { (sender, _) =>
    Future {
      sendPhoto(sender, InputFile("./bender_photo.jpg"),
                caption = "Bender the great!!!")
    }
  }
}

AsyncBot.run()

```



