package org.example

case class Person(name: String, age: Int):
  def appendToName(suffix: String) : Person =
    Person(s"$name$suffix", age)

object Person:
  // the compiler will not generate `apply` once its defined.
  def apply(name: String, age: Int) : Person =
    val capitalizedName =
      if !name.isEmpty then
        val firstChar = name.charAt(0).toUpper
        val restOfName = name.substring(0)
        s"$firstChar$restOfName"
      else throw new IllegalArgumentException("Empty name")
    new Person(capitalizedName, age)


