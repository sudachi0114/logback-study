package com.github.sudachi0114.logexample

import com.github.sudachi0114.logexample.LogExample.logger
import net.logstash.logback.marker.LogstashMarker

object MarkerLogging {
  import net.logstash.logback.marker.Markers._
  import scala.jdk.CollectionConverters._
  logger.info(append("KEY", "VALUE"), "Markers.append")
  logger.info(appendEntries(Map("k1" -> "v1", "k2" -> "v2").asJava), "Markers.appendEntries")
  logger.info(appendArray("array", "a", "b", "c"), "Markers.appendArray")
  logger.info(appendRaw("raw", """{"KEY":"VALUE"}"""), "Markers.appendRaw")

  // 複数の Markers を組み合わせることも可能
  val marker : LogstashMarker = append("KEY_A", "VALUE_A").and(append("KEY_B", "VALUE_B"))
  logger.info(marker, "multiple markers")

}