package com.simulation.weather.service

import com.simulation.weather.function.{MeasurementFunction, RandomFunction}
import com.simulation.weather.utils.{ResourceManager, WeatherJsonParser}
import com.typesafe.config.Config
import scala.io.Source

/**
  * Created by Teja on 25/11/17.
  */
class SimulatorService(config: Config)
  extends WeatherJsonParser
    with ResourceManager {

  private lazy val path = config.getString("resource.path")

  def run(): Unit = {
    try {
      val file = getClass.getResource(path).getFile

      manage(Source.fromFile(file)) { source =>

        val items = RandomFunction(config).pickItems(source.getLines())

        val weatherSnapshots = for (item <- items) yield parse(item)

        weatherSnapshots.foreach(snapshot => println(MeasurementFunction(config).create(snapshot) + "\n"))
      }
    }
    catch {
      case ex:Exception => println("There was an error - " + ex.getMessage)
    }
  }
}