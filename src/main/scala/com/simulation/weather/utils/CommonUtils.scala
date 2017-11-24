package com.simulation.weather.utils

import java.time.format.DateTimeFormatter

/**
  * Created by Teja on 25/11/17.
  */
object CommonUtils {
  def convertKelvinToCelcius(tempInKelvin: Double): Double = {
    tempInKelvin - 273.15
  }

  def getISOTime(time: Long): String = {
    val timeStamp = java.time.Instant.ofEpochMilli(time * 1000l)
    val formatter = DateTimeFormatter.ISO_INSTANT
    formatter.format(timeStamp)
  }
}
