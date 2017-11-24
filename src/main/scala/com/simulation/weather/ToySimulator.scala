package com.simulation.weather

import com.simulation.weather.service.SimulatorService
import com.typesafe.config.ConfigFactory

/**
  * Created by Teja on 25/11/17.
  */
object ToySimulator{

  //command to run on terminal: sbt "run-main com.simulation.weather.ToySimulator"

  def main(args: Array[String]) = {
    val config = ConfigFactory.load()
    new SimulatorService(config).run()
  }
}
