package com.simulation.weather

import com.simulation.weather.constants.Condition
import com.simulation.weather.function.InterpreterFunction
import com.typesafe.config.Config
import org.scalamock.scalatest.MockFactory
import org.scalatest._
import scala.collection.JavaConverters._

/**
  * Created by Teja on 25/11/17.
  */
class InterpreterFunctionTest extends FunSpec with MockFactory {

  private val mockConfig: Config = stub[Config]

    type T = java.util.List[java.lang.Integer]
    mockConfig.getIntList _ when "condition.codes.snow" returns List(600,601,602,611).asJava.asInstanceOf[T]
    mockConfig.getIntList _ when "condition.codes.rain" returns List(200,201,202,210).asJava.asInstanceOf[T]
    mockConfig.getIntList _ when "condition.codes.sunny" returns List(801,802,803,804).asJava.asInstanceOf[T]

  describe("Interpreter Function") {
    it("should return weather condition as SNOW if weather id is 6xx") {
      val actualCondition = InterpreterFunction(mockConfig).getConditionByWeatherId(601)
      assert(actualCondition.equals(Condition.Snow))
    }
    it("should return weather condition as RAIN if weather id is 2xx") {
      val actualCondition = InterpreterFunction(mockConfig).getConditionByWeatherId(202)
      assert(actualCondition.equals(Condition.Rain))
    }
    it("should return weather condition as SUNNY if weather id is 8xx") {
      val actualCondition = InterpreterFunction(mockConfig).getConditionByWeatherId(804)
      assert(actualCondition.equals(Condition.Sunny))
    }
    it("should return weather condition as OTHERS if weather id is anything else") {
      val actualCondition = InterpreterFunction(mockConfig).getConditionByWeatherId(450)
      assert(actualCondition.equals(Condition.Others))
    }
  }
}
