package com.github.sudachi0114.jackson

case class Organization(name: String, persons: List[Person]){
  def getName: String = name
  def getPersons: List[Person] = persons
}
