package com.github.sudachi0114.logexample

import org.slf4j.LoggerFactory

object LogExample {
  val logger = LoggerFactory.getLogger(getClass)

  logger.info("Hello Logging with JSON!")
}