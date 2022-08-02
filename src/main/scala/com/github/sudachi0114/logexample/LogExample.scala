package com.github.sudachi0114.logexample

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

}