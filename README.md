Example of uisng [Gatling](http://gatling-tool.org/) for simple load
testing. In particular focused on making assertions against the results
in a manner useful during continuous integration.

To run the test you'll need Maven installed and then run:

    mvn gatling:execute -Dgatling.simulationClass=ExampleSimulation

All the interesting bits are in
`src/test/scala/ExampleSimulation.scala`, in particular the assertions.

```scala
global.successfulRequests.percent.is(100),
global.responseTime.max.lessThan(1000),
global.responseTime.mean.lessThan(750),
global.requestsPerSec.lessThan(10)
```

Work based on the [official
example](https://github.com/excilys/gatling-maven-plugin-demo).
