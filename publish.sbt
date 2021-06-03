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

pomExtra in Global := (
  <url>https://github.com/Prince951-17/bot4scala</url>
    <licenses>
      <license>
        <name>Apache 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:Prince951-17/bot4scala.git</url>
      <connection>scm:git:git@github.com:Prince951-17/bot4scala.git</connection>
    </scm>
    <developers>
      <developer>
        <id>Prince</id>
        <name>Maftunbek Raxmatov</name>
        <url>https://github.com/Prince951-17</url>
      </developer>
    </developers>
  )