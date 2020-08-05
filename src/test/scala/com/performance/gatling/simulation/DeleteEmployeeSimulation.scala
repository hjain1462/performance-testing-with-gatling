package com.performance.gatling.simulation

import com.performance.gatling.common._
import com.performance.gatling.configs.Simulations._
import io.gatling.core.Predef._

class DeleteEmployeeSimulation extends Simulation with HttpProtocols with UserInjection with Scenarios {

  def deleteEmployeeScenario(): Unit = {
    setUp(
      scenario3
        .inject(injectionSteps)
        .protocols(httpProtocols)
    )
      .assertions(global.successfulRequests.percent.gte(SUCCESS_RATE))
      .assertions(global.responseTime.percentile(MAX_RESPONSE_TIME_PERCENTILE).lte(MAX_RESPONSE_TIME))
  }

  deleteEmployeeScenario()
}
