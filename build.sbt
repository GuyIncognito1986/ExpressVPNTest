name := "ExpressVPNTest"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "latest.integration" % Test,
  "com.typesafe.akka" %% "akka-actor" % "latest.integration" % Test,
  "com.typesafe.akka" %% "akka-http" % "latest.integration" % Test,
  "com.typesafe.akka" %% "akka-stream" % "latest.integration" % Test,
  "org.specs2" %% "specs2-core" % "latest.integration" % Test,
  "com.github.tomakehurst" % "wiremock" % "latest.integration" % Test,
  "org.scalacheck" %% "scalacheck" % "latest.integration" % Test
)

