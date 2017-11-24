package com.simulation.weather.function

import com.simulation.weather.dto.{Location, Measurement, Position, WeatherSnapshot}
import com.simulation.weather.utils.CommonUtils
import com.typesafe.config.Config

/**
  * Created by Teja on 24/11/17.
  */
class MeasurementFunction(config: Config) {
  def create(snapshot: WeatherSnapshot): Measurement = {

    Measurement(
      location = Location(
        Some(snapshot.city),
        Position(snapshot.latitude, snapshot.longitude)),
      localTime = CommonUtils.getISOTime(snapshot.time),
      condition = InterpreterFunction(config).getConditionByWeatherId(snapshot.weatherId),
      temperature = CommonUtils.convertKelvinToCelcius(snapshot.temperatureInKelvin),
      pressure = snapshot.pressure,
      humidity = snapshot.humidity)
  }
}

object MeasurementFunction {
  def apply(config: Config) = new MeasurementFunction(config)
}
