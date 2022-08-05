package com.github.sudachi0114.logexample

import net.logstash.logback.marker.LogstashMarker
import org.slf4j.LoggerFactory

object LogExample {
  val logger = LoggerFactory.getLogger(getClass)

  logger.info("Hello Logging with JSON!")

  import net.logstash.logback.argument.StructuredArguments._
  import scala.jdk.CollectionConverters._
  logger.info("StructuredArguments.value {}", value("KEY", "VALUE"))
  logger.info("StructuredArguments.keyValue {}", keyValue("KEY", "VALUE"))
  logger.info("StructuredArguments.entries {}", entries(Map("k1" -> "v1", "k2" -> "v2").asJava))
  logger.info("StructuredArguments.array {}", array("array", "a", "b", "c"))

  import org.slf4j.MDC
  MDC.put("KEY", "VALUE")
  logger.info("logging with MDC")
  MDC.remove("KEY")

  logger.info("map in map", value(
    "Scala map",
    Map(
      "map" -> Map(
        "list" -> List(1, 2, 3).asJava
      ).asJava
    ).asJava
  ))

  case class User(id: Long, name: String, interests: List[String])
  val user = User(100, "userA", List("Scala", "Logging"))

  logger.info("case class logging", value(
    "case class user",
    Map(
      "id" -> user.id,
      "name" -> user.name,
      "interests" -> user.interests.asJava
    ).asJava
  ))
}