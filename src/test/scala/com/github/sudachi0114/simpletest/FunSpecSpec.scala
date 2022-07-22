package com.github.sudachi0114.simpletest

import org.scalatest.funspec.AnyFunSpec

import scala.collection.mutable
import scala.collection.mutable.Stack

class FunSpecSpec extends AnyFunSpec {
  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() == 2)
      assert(stack.pop() == 1)
    }

    it("should throw NoSuchElementException if an empty stack is poped") {
      val emptyStack = new mutable.Stack[Int]
      intercept[NoSuchElementException]{
        emptyStack.pop()
      }
    }

    it("should be error") {
      assert(1 == 2)
    }
  }
}