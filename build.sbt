ThisBuild / scalaVersion     := "3.3.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"
ThisBuild / scalacOptions ++= Seq(
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked",
  "-deprecation"
)

lazy val `sub-module-1` = project
  .settings(
    libraryDependencies += "org.playframework" %% "play-json"    % "3.0.1",
    libraryDependencies += "org.scalatest"     %% "scalatest"    % "3.2.17"   % Test,
    libraryDependencies += "org.scalatestplus" %% "mockito-4-11" % "3.2.17.0" % Test
  )

lazy val `sub-module-2` = project
  .settings(
    libraryDependencies += "org.apache.pekko" %% "pekko-http" % "1.0.0"
  )

lazy val root = (project in file("."))
  .settings(
    libraryDependencies += "org.playframework" %% "play-json" % "3.0.1"
  )
  .aggregate(`sub-module-1`, `sub-module-2`)
