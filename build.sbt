name := "owl_spray"

version := "1.0-SNAPSHOT"

libraryDependencies += "io.spray" % "spray-can" % "1.1-M8"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.1.1",
    "com.typesafe.akka" %% "akka-remote" % "2.1.1"
  )
}

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
