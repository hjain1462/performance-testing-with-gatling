package com.performance.gatling.common

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.performance.gatling.configs.Contexts._

trait HttpProtocols {

  val httpProtocols =
    http
      .baseUrl(URI)
      .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", """.*.swagger.*"""), WhiteList())
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:68.0) Gecko/20100101 Firefox/68.0")
      .contentTypeHeader("application/json")

}
