package com.simulation.weather.utils

import com.simulation.weather.dto.WeatherSnapshot
import spray.json.{JsArray, JsNumber, JsString, JsonParser}

/**
  * Created by Teja on 25/11/17.
  */
trait Parser {
  type I
  type O
  def parse(input: I):O
}

trait ParserJson extends Parser {
  type I = String
  def parse(input: I):O
}

class WeatherJsonParser extends ParserJson {
  type O = WeatherSnapshot

  def parse(line: I):O = {
    val fieldMap = JsonParser(line).asJsObject().fields

    val time = fieldMap.get("time") match {
      case Some(JsNumber(value)) => value.toLong
      case _ => 0l
    }

    val city = fieldMap("city").asJsObject().fields

    val cityName = city.get("name") match {
      case Some(JsString(value)) => value.toString
      case _ => ""
    }

    val coords = city("coord").asJsObject().fields

    val latitude = coords.get("lat") match {
      case Some(JsNumber(value)) => value.toDouble
      case _ => 0.0
    }

    val longitude = coords.get("lon") match {
      case Some(JsNumber(value)) => value.toDouble
      case _ => 0.0
    }

    val mainInfo = fieldMap("main").asJsObject().fields

    val temperatureInKelvin = mainInfo.get("temp") match {
      case Some(JsNumber(value)) => value.toDouble
      case _ => 0.0
    }

    val pressure = mainInfo.get("pressure") match {
      case Some(JsNumber(value)) => value.toDouble
      case _ => 0.0
    }

    val humidity = mainInfo.get("humidity") match {
      case Some(JsNumber(value)) => value.toInt
      case _ => 0
    }

    val weatherId = fieldMap("weather") match {
      case JsArray(data) => data(0).asJsObject().fields.get("id") match {
        case Some(JsNumber(value)) => value.toInt
        case _ => 0
      }
      case _ => 0
    }

    WeatherSnapshot(
      city = cityName,
      time = time,
      latitude = latitude,
      longitude = longitude,
      temperatureInKelvin = temperatureInKelvin,
      pressure = pressure,
      humidity = humidity,
      weatherId = weatherId)
  }
}