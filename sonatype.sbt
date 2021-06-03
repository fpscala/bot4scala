//credentials ++= (for {
//  username <- Option(System.getenv().get("SONATYPE_USERNAME"))
//  password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
//} yield Credentials("Sonatype Nexus Repository Manager", "s01.oss.sonatype.org", username, password)).toSeq

credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
