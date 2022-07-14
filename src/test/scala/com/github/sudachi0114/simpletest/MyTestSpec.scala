package com.github.sudachi0114.simpletest

import org.scalatest.funsuite.AnyFunSuite

class MyTestSpec extends AnyFunSuite {
  // test1
  test("the name is set correctly in constructor") {
    val p = new Person("hoge")
    assert(p.name == "hoge")
  }

  // test2
  test("a Person's name can be changed") {
    val p = new Person("foo")
    p.name = "bar"
    assert(p.name == "bar")
  }
}