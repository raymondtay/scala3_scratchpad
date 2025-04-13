/* (C) 2025 */
package org.example

object App:

  import ChecksumAccumulator.calculate
  def main(args: Array[String]): Unit = {
    println(greeting())

    val q = Person("sally", 49)

    for arg <- args do println(arg + ": " + calculate(arg))

    val file = java.io.File.createTempFile("remove_after_run", "-dummyfile")
    println(s"Temporary file created: ${file}")
    withPrintWriter(file) { writer =>
      writer.println(new java.util.Date)
    }
  }

  def greeting(): String = "Hello, world!"
