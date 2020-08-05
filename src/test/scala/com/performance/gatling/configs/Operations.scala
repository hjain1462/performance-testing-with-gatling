package com.performance.gatling.configs

import com.typesafe.config.ConfigFactory

object Operations {

  // Loading the config file
  private val config = ConfigFactory.load()

  //Operations which are going to test
  val CREATE_EMPLOYEE_OP_NAME: String = config.getString("operations.create_employee")
  val GET_EMPLOYEE_DETAILS_OP_NAME: String = config.getString("operations.get_employee_details")
  val UPDATE_EMPLOYEE_DETAILS_OP_NAME: String = config.getString("operations.update_employee_details")
  val DELETE_EMPLOYEE_OP_NAME: String = config.getString("operations.delete_employee")
}
