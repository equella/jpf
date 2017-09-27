name := "jpf-tools"

libraryDependencies += "org.apache.ant" % "ant" % "1.8.3"

javaSource in Compile := baseDirectory.value / "src"