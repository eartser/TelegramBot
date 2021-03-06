name := "TelegramBot"

version := "0.1"
scalaVersion in Scope.Global := "2.13.5"

inThisBuild(
  List(
    scalaVersion := "2.13.5", // 2.11.12, or 2.13.5
    semanticdbEnabled := true, // enable SemanticDB
    semanticdbVersion := scalafixSemanticdb.revision
  )
)

lazy val root = project.in(file("."))
  .settings(
    name := "TelegramBot",
    libraryDependencies ++= Seq("org.augustjune" %% "canoe" % "0.5.1"),
    scalacOptions += "-Wunused:imports"
  ).aggregate(app)

lazy val app = project.in(file("app"))
  .settings (
    Compile / run/ mainClass := Some("org.app.MainApp"),
    libraryDependencies ++= Seq("org.scalactic" %% "scalactic" % "3.2.8",
                                "org.scalatest" %% "scalatest" % "3.2.8" % "test"),
    scalacOptions += "-Wunused:imports",
    dependencyUpdatesFailBuild := true
  )