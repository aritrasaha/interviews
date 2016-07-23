name := "ClearTax"

version := "1.0"

lazy val root = (project in file("."))
    .enablePlugins(PlayJava, PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  cache,
  filters,

  "org.projectlombok" % "lombok" % "1.16.8" % Compile
)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

pipelineStages := Seq(digest, gzip)
