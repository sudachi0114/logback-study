package com.github.sudachi0114.simpletest

object Main extends App {
  val p = new Person("sudachi")
  println(s"Hello ${p.name}")
}

class Person(var name: String)