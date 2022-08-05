package com.github.sudachi0114.simpletest

import com.github.sudachi0114.logexample.LogExample

object Main extends App {
  val p = new Person("sudachi")
  println(s"Hello ${p.name}")

  LogExample
}

class Person(var name: String)