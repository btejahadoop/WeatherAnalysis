name := "WeatherAnalysis"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "io.spray" % "spray-json_2.10" % "1.2.5",
  "com.typesafe" % "config" % "1.3.0",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test")