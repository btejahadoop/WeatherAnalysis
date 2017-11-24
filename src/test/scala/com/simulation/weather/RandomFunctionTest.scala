package com.simulation.weather

import java.util.UUID

import com.simulation.weather.function.RandomFunction
import com.typesafe.config.Config
import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSpec

/**
  * Created by Teja on 25/11/17.
  */
class RandomFunctionTest extends FunSpec with MockFactory {

  val mockConfig = stub[Config]

  describe("Random Function") {
    it ("should get n samples from given collection as given in config") {

      val sampleCount = 5
      mockConfig.getInt _ when "sample.count" returns sampleCount

      val biggerCollection = for (i <- 1 to 50) yield UUID.randomUUID().toString

      val actualSample = RandomFunction(mockConfig).pickItems(biggerCollection.toIterator)

      assert(actualSample.size.equals(sampleCount))
    }
  }
}
