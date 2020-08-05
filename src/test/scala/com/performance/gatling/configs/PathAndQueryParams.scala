package com.performance.gatling.configs

import com.typesafe.config.ConfigFactory

object PathAndQueryParams {

  // Loading the config file
  private val config = ConfigFactory.load()

  // Path and Query Params
  val AA_USERNAME: String = config.getString("credentials.aa_username")
  val US_USERNAME: String = config.getString("credentials.us_username")
  val AA_PASSWORD: String = config.getString("credentials.aa_password")
  val US_PASSWORD: String = config.getString("credentials.us_password")

}