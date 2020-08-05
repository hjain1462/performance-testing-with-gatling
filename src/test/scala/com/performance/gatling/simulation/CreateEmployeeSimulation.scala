package com.performance.gatling.simulation

import com.performance.gatling.common._
import com.performance.gatling.configs.Endpoints._
import com.performance.gatling.configs.Simulations._
import io.gatling.core.Predef._

import scala.reflect.io.File

class CreateEmployeeSimulation extends Simulation with HttpProtocols with UserInjection with Scenarios {

  // before will always before your simulation starts
  before {
    println("Print empId in the users.csv file")
    File(EMPLOYEE_CREATED_FILE_PATH).appendAll("empId" + "\n")
  }


  def createEmployeeScenario(): Unit = {
    setUp(
      scenario1
        .inject(injectionSteps)
        .protocols(httpProtocols)
    )
      .assertions(global.successfulRequests.percent.gte(SUCCESS_RATE))
      .assertions(global.responseTime.percentile(MAX_RESPONSE_TIME_PERCENTILE).lte(MAX_RESPONSE_TIME))

  }

  createEmployeeScenario()
}