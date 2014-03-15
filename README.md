Example of uisng [Gatling](http://gatling-tool.org/) for simple load
testing. In particular focused on making assertions against the results
in a manner useful during continuous integration.

[![wercker
status](https://app.wercker.com/status/7e1aaeb43b0c231f46d4725bac3230ae/s/
"wercker
status")](https://app.wercker.com/project/bykey/7e1aaeb43b0c231f46d4725bac3230ae)

## Usage

To run the test you'll need Maven installed and then run:

    mvn gatling:execute -Dgatling.simulationClass=ExampleSimulation

Note that will make a small number of requests of garethrushgrove.com.
You'll probably want to change the target in the code.

## Why

All the interesting bits are in
`src/test/scala/ExampleSimulation.scala`, in particular the assertions.

Gatling appears to be the best load testing tool for making rolled up
assertions like the following, which are nice to have if adding load
testing to a continuous integation pipeline.

```scala
global.successfulRequests.percent.is(100),
global.responseTime.max.lessThan(1000),
global.responseTime.mean.lessThan(750),
global.requestsPerSec.lessThan(10)
```

## Thanks

Most of this is based on the [official maven plugin example](https://github.com/excilys/gatling-maven-plugin-demo).
