package com.github.sudachi0114.logexample

import org.scalatest.funspec.AnyFunSpec

object MDCLoggingSpec extends AnyFunSpec {
  describe("logback MDC logging test") {
    it("should call MDCLogging") {
      MDCLogging
    }
  }
}