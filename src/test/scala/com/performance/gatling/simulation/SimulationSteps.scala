package com.performance.gatling.simulation

import com.performance.gatling.common._
import com.performance.gatling.configs.Endpoints._
import io.gatling.core.body.Body
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.request.builder.HttpRequestBuilder

import scala.reflect.io.File
import scala.util.Random

trait SimulationSteps extends Constants with Responses {

  val randomFeeder = Iterator.continually(
    Map("RANDOM_VALUE" -> Random.nextInt(Integer.MAX_VALUE))
  )

  def validateRequest(statusCode: Int, response: HttpRequestBuilder): HttpRequestBuilder = {
    response.check(status.is(statusCode))

  }

  def sendGetRequest(actionName: String, endpoint: String): HttpRequestBuilder = {
    http(actionName)
      .get(endpoint)
  }

  def sendPostRequest(actionName: String, path: String, jsonBody: Body): HttpRequestBuilder = {
    http(actionName)
      .post(path)
      .body(jsonBody)
  }

  def sendPutRequest(actionName: String, path: String, jsonBody: Body): HttpRequestBuilder = {
    http(actionName)
      .put(path)
      .body(jsonBody)
  }

  def sendDeleteRequest(actionName: String, endpoint: String): HttpRequestBuilder = {
    http(actionName)
      .delete(endpoint)
  }

  def saveEmpId(builder: HttpRequestBuilder): ChainBuilder = {
    exec(builder.check(jsonPath(EMPLOYEE_ID).saveAs("empId")))
      .exec(session => {
        File(EMPLOYEE_CREATED_FILE_PATH).appendAll(session("empId").as[String] + "\n")
        session
      }
      )
  }

}