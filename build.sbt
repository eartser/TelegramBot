name := "TelegramBot"

version := "0.1"

lazy val root = project.in(file("."))
  .settings(
    name := "TelegramBot",
    scalaVersion := "2.13.5",
    libraryDependencies += "org.augustjune" %% "canoe" % "0.5.1",
    libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  )