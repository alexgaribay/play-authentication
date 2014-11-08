name := """play-authentication"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "com.typesafe.play" %% "play-slick" % "0.8.0",
  "org.mindrot" % "jbcrypt" % "0.3m"
)
