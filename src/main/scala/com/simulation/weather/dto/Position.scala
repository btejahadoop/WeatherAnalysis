package com.simulation.weather.dto

/**
  * Created by Teja on 24/11/17.
  */
case class Position (latitude: Double, longitude: Double, elevation: Double = 100.000) {

  override def toString: String = {
    "%.3f,%.3f,%.3f".format(latitude, longitude, elevation)
  }
}
