package com.github.sudachi0114.simpletest

import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

import scala.collection.mutable.Stack

class FunSpecSpec extends AnyFunSpec with BeforeAndAfter {

  var stack: Stack[Int] = _

  before {
    stack = new Stack[Int]
  }

  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() == 2)
      assert(stack.pop() == 1)
    }

    it("should throw NoSuchElementException if an empty stack is poped") {
      intercept[NoSuchElementException]{
        stack.pop()
      }
    }
  }
}