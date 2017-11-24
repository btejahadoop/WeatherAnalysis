# WeatherAnalysis
This is a simulation tool implemented in SCALA language to generate weather data which can be used in certain games.

Implementation:
- Use auweatherdata as a sample source of data
- Get the resource from given path and read it to get all the weather items as collection.
- Apply Random method from Scala.util to shuffle the collection of line items and then pick N samples as weather snapshots.
- Go through shortlisted weather snapshots to create measurement and print them individually in the given format.

How to run:
- sbt test
- sbt "run-main com.simulation.weather.ToySimulator"
