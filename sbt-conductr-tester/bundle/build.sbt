import ByteConversions._

// Note that this bundle can not be started (`conduct run`) because the program does not signal that it has been started.

name := "bundle"
version := "1.0.0"
scalaVersion := "2.11.8"

// ConductR
BundleKeys.nrOfCpus := 0.1
BundleKeys.memory := 64.MiB
BundleKeys.diskSpace := 10.MB
BundleKeys.endpoints := Map("web" -> Endpoint("http", 0, Set(URI("http://:9001"))))

BundleKeys.configurationName := "web-server"

lazy val WebServer2 = config("web-server2").extend(BundleConfiguration)
BundlePlugin.configurationSettings(WebServer2)
BundleKeys.configurationName in WebServer2 := "web-server2"

lazy val root = project
  .in(file("."))
  .enablePlugins(JavaAppPackaging)
  .configs(WebServer2)
