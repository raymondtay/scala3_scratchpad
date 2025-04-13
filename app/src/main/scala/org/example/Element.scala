/* (C) 2025 */
package org.example

import Element.elem

abstract class Element:

  def contents: Vector[String]
  def width: Int =
    if height == 0 then 0 else contents(0).length
  def height: Int = contents.length
  def above(that: Element): Element =
    elem(this.contents ++ that.contents)
  def beside(that: Element): Element =
    elem(
      for (line1, line2) <- this.contents.zip(that.contents)
      yield line1 ++ line2
    )
  override def toString = contents.mkString("\n")
end Element

object Element:
  private class VectorElement(val contents: Vector[String]) extends Element
  private class LineElement(s: String) extends Element:
    val contents        = Vector(s)
    override def width  = s.length
    override def height = 1
  private class UniformElement(
      ch: Char,
      override val width: Int,
      override val height: Int
  ) extends Element:
    private val line = ch.toString * width
    def contents     = Vector.fill(height)(line)

  def elem(contents: Vector[String]): Element =
    VectorElement(contents)

  def elem(char: Char, width: Int, height: Int): Element =
    UniformElement(char, width, height)

  def elem(line: String): Element =
    LineElement(line)
