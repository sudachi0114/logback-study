package com.github.sudachi0114.logexample

import org.slf4j.LoggerFactory

object LogExample extends App {
  val logger = LoggerFactory.getLogger(getClass)

  logger.info("Hello Logging with JSON!")
}