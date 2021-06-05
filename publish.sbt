publishMavenStyle := true

pomIncludeRepository := { _ => true }

sonatypeProfileName := "com.prince"
releaseIgnoreUntrackedFiles := true

sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
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
    "scm:git:https://github.com/Prince951-17/bot4scala.git"
  )
)
