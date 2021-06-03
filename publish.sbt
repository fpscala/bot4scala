publishMavenStyle := true

pomIncludeRepository := { _ => false }

sonatypeProfileName := "com.prince"
releaseIgnoreUntrackedFiles := true

publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
scmInfo := Some(
  ScmInfo(
    url("https://github.com/Prince951-17/bot4scala"),
    "scm:git:git@github.com:Prince951-17/bot4scala.git"
  )
)
