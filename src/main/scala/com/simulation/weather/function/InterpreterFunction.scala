package com.simulation.weather.function

import com.simulation.weather.constants.Condition
import com.simulation.weather.constants.Condition._
import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by Teja on 24/11/17.
  */
object InterpreterFunction {
  def apply(config: Config) = new InterpreterFunction(config)
}

class InterpreterFunction(config:Config) {
  private[this] lazy val snowCodes = ConfigFactory.load().getIntList("condition.codes.snow")
  private[this] lazy val rainCodes = ConfigFactory.load().getIntList("condition.codes.rain")
  private[this] lazy val sunnyCodes = ConfigFactory.load().getIntList("condition.codes.sunny")

  def getConditionByWeatherId(weatherId: Int): Condition = {

    weatherId match {
      case x if snowCodes.contains(x) => Condition.Snow
      case y if rainCodes.contains(y) => Condition.Rain
      case z if sunnyCodes.contains(z) => Condition.Sunny
      case _ => Condition.Others
    }
  }
}
