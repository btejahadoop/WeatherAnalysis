package com.simulation.weather

import com.simulation.weather.utils.CommonUtils
import org.scalatest.FunSpec

/**
  * Created by Teja on 25/11/17.
  */
class CommonUtilsTest extends FunSpec{

  describe("Common Utils") {
    it("should correctly convert temperature in Kelvin to Degree Celcius") {
      val actualTemp = CommonUtils.convertKelvinToCelcius(295.65)

      assert(actualTemp.equals(22.5))
    }

    it("should correctly return millisecond timestamp to ISO date time format") {
      val actualTime = CommonUtils.getISOTime(1459801448)

      assert(actualTime.equals("2016-04-04T20:24:08Z"))
    }
  }
}
