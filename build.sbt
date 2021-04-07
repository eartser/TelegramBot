name := "TelegramBot"

version := "0.1"

lazy val root = project.in(file("."))
  .settings(
    name := "TelegramBot",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq("org.augustjune" %% "canoe" % "0.5.1",
                                "org.scalatest" % "scalatest_2.10" % "2.0" % "test"),
  ).aggregate(app)

lazy val app = project.in(file("app"))
  .settings (
    Compile / run/ mainClass := Some("org.app.MainApp")
  )
