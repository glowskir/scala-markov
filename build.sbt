name := "markov"

organization := "org.conbere"

version := "0.2.0"

scalaVersion := "2.11.+"

scalacOptions += "-deprecation"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "latest.integration" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

testOptions in Test += Tests.Argument("-oDF")

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) {
    Some("snapshots" at nexus + "content/repositories/snapshots")
  } else {
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  }
}

pomIncludeRepository := { _ => false }

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("http://github.com/aconbere/scala-markov"))

pomExtra := (
  <scm>
    <url>git@github.com:aconbere/scala-markov.git</url>
    <connection>scm:git:git@github.com:aconbere/scala-markov.git</connection>
  </scm>
  <developers>
    <developer>
      <id>aconbere</id>
      <name>Anders Conbere</name>
      <url>http://anders.conbere.org</url>
    </developer>
  </developers>)
