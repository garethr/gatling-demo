import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import bootstrap._
import assertions._

class ExampleSimulation extends Simulation {

  val httpConf = http.baseURL("http://www.garethrushgrove.com")

  val sample = scenario("Simple example").exec(
    http("Homepage").get("/").check(status.is(200))
  )

  setUp(sample.inject(ramp(3 users) over (10 seconds)))
    .protocols(httpConf)
    .assertions(
      global.successfulRequests.percent.is(100),
      global.responseTime.max.lessThan(1000),
      global.responseTime.mean.lessThan(750),
      global.requestsPerSec.lessThan(10)
  )
}
