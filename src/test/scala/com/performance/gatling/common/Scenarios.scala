package com.performance.gatling.common

import com.performance.gatling.simulation.SimulationSteps
import io.gatling.core.Predef._
import com.performance.gatling.configs.Operations._
import com.performance.gatling.configs.Endpoints._
import com.performance.gatling.configs.JsonPaths._

trait Scenarios extends Simulation with SimulationSteps {


  // In this scenario, ElFileBody is used because of random value passed in json,
  // If you want to pass constant json, then use RawFileBody instead of ElFileBody

  val scenario1 = scenario("Employee cration and save all the employees in csv file")
    .group("Employee Creation")(
      feed(randomFeeder)
        .exec(saveEmpId(validateRequest(HTTP_OK, sendPostRequest(CREATE_EMPLOYEE_OP_NAME, CREATE_EMPLOYEE_PATH, ElFileBody(CREATE_EMPLOYEE_JSON_PATH)).asJson)))
    )

  // Here, employee csv file is passed for deletion of employee one by one

  val scenario2 = scenario("update the employee details")
    .group("update employee details")(
      feed(csv(EMPLOYEE_CREATED_FILE_PATH))
        .exec(validateRequest(HTTP_OK, sendPutRequest(UPDATE_EMPLOYEE_DETAILS_OP_NAME, UPDATE_EMPLOYEE_DETAILS_PATH, ElFileBody(UPDATE_EMPLOYEE_JSON_PATH)).asJson))
    )

  // Here, employee csv file is passed for deletion of employee one by one

  val scenario3 = scenario("Get the employee and delete the user")
    .group("User Deletion")(
      feed(csv(EMPLOYEE_CREATED_FILE_PATH))
        .exec(validateRequest(HTTP_OK, sendDeleteRequest(DELETE_EMPLOYEE_OP_NAME, DELETE_EMPLOYEE_PATH)))
    )
}