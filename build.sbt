import sbt.{Developer, ScmInfo, url}

name := "jpf"

def commonSettings = Seq(
  version := "1.0.7",
  organization := "com.github.equella.jpf",
  licenses := Seq("LGPLv2.1" -> url("https://www.gnu.org/licenses/old-licenses/lgpl-2.1.en.html")),
  homepage := Some(url("https://github.com/equella/jpf")),
  autoScalaLibrary := false,
  developers := List(
    Developer(
      id = "doolse",
      name = "Jolse Maginnis",
      email = "doolse@gmail.com",
      url = url("https://github.com/doolse")
    )
  ),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/equella/jpf"), "scm:git@github.com:equella/jpf.git"
    )
  ),
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  crossPaths := false)

commonSettings

javaSource in Compile := baseDirectory.value / "source"

val jpf = project in file(".")
val jpf_tools = (project in file("source-tools")).settings(commonSettings).dependsOn(jpf)
val jpf_boot = (project in file("source-boot")).settings(commonSettings).dependsOn(jpf)

libraryDependencies += "commons-logging" % "commons-logging" % "1.0.4"
