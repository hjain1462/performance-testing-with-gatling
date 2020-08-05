package com.performance.gatling.configs

import com.typesafe.config.ConfigFactory

object Contexts {

  // Loading the config file
  private val config = ConfigFactory.load()

  // Base URLs of the Application
  val URI: String = config.getString("URI")
}