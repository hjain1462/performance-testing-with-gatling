package com.performance.gatling.common

import io.gatling.core.Predef._
import scala.concurrent.duration._
import com.performance.gatling.configs.Simulations._

trait UserInjection {

  val injectionSteps = {

    atOnceUsers(3)

//    rampUsersPerSec(INITIAL_NOF_USERS) to MAX_NOF_USERS during (RAMP_DURATION.toSeconds seconds)
//    constantUsersPerSec(MAX_NOF_USERS) during (CONSTANT_DURATION.toSeconds seconds)
  }

}
