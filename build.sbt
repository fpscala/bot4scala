import sbt.Keys.{crossScalaVersions, publishArtifact}

lazy val scala2_13              = "2.13.5"
lazy val scala2_12              = "2.12.12"
lazy val supportedScalaVersions = List(scala2_12, scala2_13)

lazy val bot4scala = (project in file("."))
  .settings(
    releaseIgnoreUntrackedFiles := true,
    publish / skip := true,
    crossScalaVersions := Nil
    ).aggregate(core, examples)

version := "1.0"
organization := "uz.scala"
publishArtifact in Test := false
publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots/")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
scmInfo := Some(
  ScmInfo(
    url("https://github.com/Prince951-17/bot4scala"),
    "scm:git:https://github.com/Prince951-17/bot4scala.git"
    )
  )
licenses ++= Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
homepage := Some(url("https://github.com/Prince951-17/bot4scala"))
description := "Telegram Bot API for scala"
developers := List(
  Developer("Prince", "Maftunbek Raxmatov", "prince777_98@mail.ru", url("https://github.com/Prince951-17"))
  )

lazy val core = project
  .in(file("core"))
  .settings(
    name := "bot4scala",
    compilerOptions,
    publishMavenStyle := true,
    pomIncludeRepository := { _ => false },
    crossScalaVersions := supportedScalaVersions,
    libraryDependencies ++= Seq(
      "org.scalaj" %% "scalaj-http" % "2.4.2",
      "org.json4s" %% "json4s-native" % "4.0.0"
      )
    )

lazy val examples = project
  .in(file("examples"))
  .settings(
    name := "bot4scala-examples",
    publish / skip := true,
    crossScalaVersions := supportedScalaVersions
    ).dependsOn(core)

lazy val compilerOptions =
  scalacOptions ++= Seq(
    "-Xfatal-warnings", // Fail the compilation if there are any warnings.
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-explaintypes", // Explain type errors in more detail.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-language:higherKinds", // Allow higher-kinded types
    "-language:postfixOps", // Allow higher-kinded types
    "-language:implicitConversions", // Allow definition of implicit functions called views
    "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
    "-Ywarn-unused:imports", // Warn if an import selector is not referenced.
    "-Ywarn-unused:locals", // Warn if a local definition is unused.
    // "-Ywarn-unused:params", // Warn if a value parameter is unused.
    "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
    "-Ywarn-unused:privates", // Warn if a private member is unused.
    "-Ywarn-value-discard" // Warn when non-Unit expression results are unused.
    ) ++ (if (scalaBinaryVersion.value.startsWith("2.12")) List("-Ypartial-unification") else Nil)
credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
pomExtra := <developers>
  <developer>
    <id>Prince951-17</id>
    <name>Maftunbek Raxmatov</name>
    <url>https://github.com/Prince951-17</url>
  </developer>
</developers>