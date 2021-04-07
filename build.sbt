name := "TelegramBot"

version := "0.1"

lazy val root = project.in(file("."))
  .settings(
    name := "TelegramBot",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq("org.augustjune" %% "canoe" % "0.5.1",
                                "org.scalatest" % "scalatest" % "3.2.5" % "test"),
  ).aggregate(app)

lazy val app = project.in(file("app"))
  .settings (
    Compile / run/ mainClass := Some("org.app.MainApp"),
    libraryDependencies += "org.scalatest" % "scalatest" % "3.2.5" % "test"
  )
