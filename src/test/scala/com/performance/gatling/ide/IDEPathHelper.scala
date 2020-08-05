package com.performance.gatling.ide

import java.nio.file.Path

import io.gatling.commons.util.PathHelper._

object IDEPathHelper {

  val gatlingConfUrl: Path = getClass.getClassLoader.getResource("reference.conf")
  val projectRootDir: Path = gatlingConfUrl.ancestor(3)

  val mavenResourcesDirectory: Path = projectRootDir / "src" / "test" / "resources"
  val mavenTargetDirectory: Path = projectRootDir / "target"

  val resultsDirectory: Path = mavenTargetDirectory / "gatling"
  val mavenBinariesDirectory: Path = mavenTargetDirectory / "test-classes"
}
