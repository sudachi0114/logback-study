package com.github.sudachi0114.jackson

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

class JacksonModuleSpec extends AnyFunSpec with Matchers {

  describe("JacksonModuleSpec") {
    it("should parse json into case class") {
      val json =
        """|{"name":"some organization",
           | "persons":
           |  [{"name":"Taro","age":22},
           |   {"name":"Hanako","age":18},
           |   {"name":"Saburo","age":25}]}""".stripMargin
       println(json)

      // Scala モジュールを使う時は、Jackson の ObjectMapper に DefaultScalaModule を登録すればよい
      val mapper = new ObjectMapper
      mapper.registerModule(DefaultScalaModule)

      val parsedJson = mapper.readValue(json, classOf[Organization])

      val expectedPersons = List(Person("Taro", 22), Person("Hanako", 18), Person("Saburo", 25))
      val expectedOrganization = Organization("some organization", expectedPersons)

      parsedJson should be (expectedOrganization)
    }
  }

  it("should produce json from case class") {
    val persons = List(Person("Shirou", 100), Person("Goro", 22), Person("Rokuro", 48))
    val organization = Organization("another organization", persons)

    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)

    val expectedString = """{"name":"another organization","persons":[{"name":"Shirou","age":100},{"name":"Goro","age":22},{"name":"Rokuro","age":48}]}"""

    mapper.writeValueAsString(organization) should be (expectedString)
  }
}