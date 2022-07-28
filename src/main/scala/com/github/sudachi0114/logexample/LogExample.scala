package com.github.sudachi0114.logexample

import org.slf4j.LoggerFactory

object LogExample {
  val logger = LoggerFactory.getLogger(getClass)

  logger.info("Hello Logging with JSON!")

  import net.logstash.logback.argument.StructuredArguments._
  import scala.collection.JavaConverters._
  logger.info("StructuredArguments.value {}", value("KEY", "VALUE"))       // 単一の値を追加する
  logger.info("StructuredArguments.keyValue {}", keyValue("KEY", "VALUE")) // 単一の値を追加する
  logger.info("StructuredArguments.entries {}", entries(Map("k1" -> "v1", "k2" -> "v2").asJava)) // 複数の値を追加する
  logger.info("StructuredArguments.array {}", array("array", "a", "b", "c"))  // 複数の値を追加する
  logger.info("StructuredArguments.raw {}", raw("raw", """{"KEY":"VALUE"}""")) // Raw な JSON で追加する
}