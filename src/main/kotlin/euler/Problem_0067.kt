package euler.problem0067

import java.io.File
import java.lang.Math.max
import java.util.ArrayList

import euler.loadRowsFrom
import euler.zipWith3

fun main(args: Array<String>) {
  val triangle = loadRowsFrom(File("src/main/resources/Problem-0067.txt"))

  // see http://www.haskell.org/haskellwiki/Euler_problems/11_to_20#Problem_18
  val f = { x: Int, y: Int, z: Int -> x + max(y, z).toInt() }
  val g = { row1: List<Int>, row2: List<Int> -> zipWith3(f, row1, row2, row2.drop(1)) }

  // average execution time of 0.7373 milliseconds over 10 iterations
  val result = triangle.reduceRight(g).first()
  println("the maximum total from top to bottom of the triangle is $result")
}
