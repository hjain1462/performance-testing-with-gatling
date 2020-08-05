package com.performance.gatling.configs

import com.typesafe.config.ConfigFactory

object JsonPaths {

  // Loading the config file
  private val config = ConfigFactory.load()

  // Get Json path
  val CREATE_EMPLOYEE_JSON_PATH: String = config.getString("json.create_employee")
  val UPDATE_EMPLOYEE_JSON_PATH: String = config.getString("json.update_employee_details")

}