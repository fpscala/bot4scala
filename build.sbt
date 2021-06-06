import sbtrelease.ReleaseStateTransformations._

version := "1.0"

val scala2_13 = "2.13.5"
val scala2_12 = "2.12.12"
lazy val bot4scala = (project in file(".")).aggregate(core, examples)

lazy val projectSettings = Seq(
  ThisBuild / version := "1.0",
  organization := "uz.scala",
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
    publishTo in ThisBuild := {
    val nexus = "https://s01.oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/Prince951-17/bot4scala"),
      "scm:git:https://github.com/Prince951-17/bot4scala.git"
    )
  ),
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    publishArtifacts,
    setNextVersion,
    commitNextVersion,
    ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
    pushChanges
  ),
  licenses ++= Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  homepage := Some(url("https://github.com/Prince951-17/bot4scala")),
  developers := List(Developer("Prince", "Maftunbek Raxmatov", "prince777_98@mail.ru", url("https://github.com/Prince951-17"))),
  scalaVersion := scala2_12,

  credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials"),
  resolvers += Resolver.mavenLocal,
  crossScalaVersions := Seq(scala2_13, scalaVersion.value)
  )

lazy val core = project
  .in(file("core"))
  .settings(
    name := "bot4scala",
    projectSettings,
    compilerOptions,
    )
  .settings(
    libraryDependencies ++= Seq(
      "org.scalaj" %% "scalaj-http" % "2.4.2",
      "org.json4s" %% "json4s-native" % "3.2.11"
      )
    )

lazy val examples = project
  .in(file("examples"))
  .settings(
    name := "bot4scala-examples",
    skip.in(publish) := true,
    projectSettings,
    crossScalaVersions := Seq(scalaVersion.value)
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