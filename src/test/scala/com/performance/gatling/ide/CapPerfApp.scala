package com.performance.gatling.ide

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object CapPerfApp extends App {

  def builder(simulationClass: String) = {

    new GatlingPropertiesBuilder()
      .resultsDirectory(IDEPathHelper.resultsDirectory.toString)
      .binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString)
      .simulationClass(simulationClass).build

  }

  // passing simulation file one by one as two setup method can't be run simultaneously

  Gatling.fromMap(builder("com.performance.gatling.simulation.CreateEmployeeSimulation"))
  Gatling.fromMap(builder("com.performance.gatling.simulation.UpdateEmployeeDetailsSimulation"))
  Gatling.fromMap(builder("com.performance.gatling.simulation.DeleteEmployeeSimulation"))

}