package com.github.sudachi0114.simpletest

import org.scalatest.funspec.AnyFunSpec

class MyTestSpec extends AnyFunSpec {

  describe("Main test") {
    // test1
    it("should set correctly name in constructor") {
      val p = new Person("hoge")
      assert(p.name == "hoge")
    }

    // test2
    it("should be able to change name Person") {
      val p = new Person("foo")
      p.name = "bar"
      assert(p.name == "bar")
    }
  }
}