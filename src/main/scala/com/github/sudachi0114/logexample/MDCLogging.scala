package com.github.sudachi0114.logexample

import org.slf4j.LoggerFactory

object MDCLogging {
  val logger = LoggerFactory.getLogger(getClass)

  import org.slf4j.MDC

  MDC.put("KEY", "VALUE")
  logger.info("logging with MDC")
  MDC.remove("KEY")
}