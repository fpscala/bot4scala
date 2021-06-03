publishMavenStyle := true

pomIncludeRepository := { _ => false }

sonatypeProfileName := "com.prince"
sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
releaseIgnoreUntrackedFiles := true
publishTo := sonatypePublishTo.value

// [If necessary] Settings for using custom Nexus repositories:

releasePublishArtifactsAction := PgpKeys.publishSigned.value
scmInfo := Some(
  ScmInfo(
    url("https://github.com/Prince951-17/bot4scala"),
    "scm:git:git@github.com:Prince951-17/bot4scala.git"
  )
)
