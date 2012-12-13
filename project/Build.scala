import sbt._
import Keys._

object BowlingGame extends Build {
  override lazy val settings = super.settings ++ Seq(resolvers := Seq())

  val publishedScalaSettings = Seq(
    scalaVersion := "2.10.0-RC5",
    scalaBinaryVersion <<= scalaVersion,
    libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _),
    libraryDependencies in config("macro") <+= scalaVersion("org.scala-lang" % "scala-compiler" % _),
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.6.4",
   
      // Misc for migration demo
      "com.google.guava" % "guava" % "13.0.1",
   
      // Test stuff
      "org.scalatest" %% "scalatest" % "2.0.M5-B1" % "test",
      "org.specs2" %% "specs2" % "1.13-SNAPSHOT" % "test",
      "org.mockito" % "mockito-all" % "1.9.5",
      "junit" % "junit" % "4.10" % "test",
      "org.easytesting" % "fest-assert" % "1.4" % "test",
      "org.hamcrest" % "hamcrest-core" % "1.3" % "test",
      "org.hamcrest" % "hamcrest-library" % "1.3" % "test"))

  lazy val root = Project(id = "bowling-game",
    base = file("."),
    settings = Project.defaultSettings ++ publishedScalaSettings)

}
