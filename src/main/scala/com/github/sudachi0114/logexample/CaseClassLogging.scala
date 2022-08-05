package com.github.sudachi0114.logexample

import org.slf4j.LoggerFactory


object CaseClassLogging {
  val logger = LoggerFactory.getLogger(getClass)

  import net.logstash.logback.argument.StructuredArguments._
  import scala.jdk.CollectionConverters._
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