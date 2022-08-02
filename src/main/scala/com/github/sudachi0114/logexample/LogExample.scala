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

  import net.logstash.logback.marker.Markers._
  logger.info(append("KEY", "VALUE"), "Markers.append")
  logger.info(appendEntries(Map("k1" -> "v1", "k2" -> "v2").asJava), "Markers.appendEntries")
  logger.info(appendArray("array", "a", "b", "c"), "Markers.appendArray")
  logger.info(appendRaw("raw", """{"KEY":"VALUE"}"""), "Markers.appendRaw")

  // 複数の Markers を組み合わせることも可能
  val marker : LogstashMarker = append("KEY_A", "VALUE_A").and(append("KEY_B", "VALUE_B"))
  logger.info(marker, "multiple markers")

  import org.slf4j.MDC
  MDC.put("KEY", "VALUE")
  logger.info("logging with MDC")
  MDC.remove("KEY")
}