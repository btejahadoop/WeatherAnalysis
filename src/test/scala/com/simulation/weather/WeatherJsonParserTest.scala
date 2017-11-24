package com.simulation.weather

import com.simulation.weather.dto.WeatherSnapshot
import com.simulation.weather.utils.WeatherJsonParser
import org.scalatest.FunSpec

/**
  * Created by Teja on 25/11/17.
  */
class WeatherJsonParserTest extends FunSpec{

  describe("Weather Json Parser") {
    it ("should transform the input string into an expected object") {

      val jsonData = "{\"city\":{\"id\":745042,\"name\":\"İstanbul\",\"findname\":\"İSTANBUL\",\"country\":\"TR\",\"coord\":{\"lon\":28.983311,\"lat\":41.03508},\"zoom\":1,\"langs\":[{\"bg\":\"Истанбул\"},{\"el\":\"Ισταμπούλ\"},{\"en\":\"Istanbul\"},{\"es\":\"Provincia de Estambul\"},{\"ja\":\"イスタンブール\"},{\"link\":\"http:\\/\\/en.wikipedia.org\\/wiki\\/Istanbul_Province\"},{\"no\":\"Istanbul\"},{\"ru\":\"Стамбул\"},{\"tr\":\"İstanbul\"},{\"zh\":\"伊斯坦布尔\"}]},\"time\":1394871602,\"main\":{\"temp\":283.42,\"pressure\":1021,\"temp_min\":283.15,\"temp_max\":284.15,\"humidity\":87},\"wind\":{\"speed\":2.57,\"gust\":2.57,\"deg\":220},\"clouds\":{\"all\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01d\"}]}"

      val actualOutput = new WeatherJsonParser().parse(jsonData)
      val expectedOutput = WeatherSnapshot("İstanbul",1394871602l,41.03508,28.983311,283.42,1021.0,87,800)

      assert(actualOutput.equals(expectedOutput))
    }
  }
}
