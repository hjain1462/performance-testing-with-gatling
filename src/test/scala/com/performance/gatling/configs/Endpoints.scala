package com.performance.gatling.configs

import com.typesafe.config.ConfigFactory

object Endpoints {

  // Loading the config file
  private val config = ConfigFactory.load()

  // Endpoints that needs to be tested
  val EMPLOYEE_CREATED_FILE_PATH: String = config.getString("path.employee_created_file_path")
  val CREATE_EMPLOYEE_PATH: String = config.getString("path.create_employee")
  val GET_EMPLOYEE_DETAILS_PATH: String = config.getString("path.get_employee_details")
  val UPDATE_EMPLOYEE_DETAILS_PATH: String = config.getString("path.update_employee_details")
  val DELETE_EMPLOYEE_PATH: String = config.getString("path.delete_employee")
}

