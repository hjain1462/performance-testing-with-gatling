package com.performance.gatling.configs

import java.time.Duration

import com.typesafe.config.ConfigFactory

object Simulations {

  // Loading the config file
  private val config = ConfigFactory.load()

  // Simulation Configurations
  val MAX_NOF_USERS: Int = config.getInt("simulation.max_nof_users")
  val INITIAL_NOF_USERS: Int = config.getInt("simulation.initial_nof_users")
  val RAMP_DURATION: Duration = config.getDuration("simulation.ramp_duration")
  val CONSTANT_DURATION: Duration = config.getDuration("simulation.constant_duration")
  val SUCCESS_RATE: Int = config.getInt("simulation.required_success_rate")
  val MAX_RESPONSE_TIME: Int = config.getDuration("simulation.max_response_time").toMillis.toInt
  val MAX_RESPONSE_TIME_PERCENTILE: Int = config.getInt("simulation.max_response_time_percentile")

}