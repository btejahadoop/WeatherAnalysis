package com.simulation.weather.dto

/**
  * Created by Teja on 24/11/17.
  */
case class WeatherSnapshot (
                      city: String,
                      time: Long,
                      latitude: Double,
                      longitude: Double,
                      temperatureInKelvin: Double,
                      pressure: Double,
                      humidity: Int,
                      weatherId: Int)


