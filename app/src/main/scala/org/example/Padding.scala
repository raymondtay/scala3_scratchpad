/* (C) 2025 */
package org.example

object Padding:

  def padLines(text: String, minWidth: Int): String =

    def padLine(line: String, minWidth: Int): String =
      if line.length >= minWidth then line
      else line + " " * (minWidth - line.length)

    val paddedLines =
      for line <- text.linesIterator yield padLine(line, minWidth)

    paddedLines.mkString("\n")
