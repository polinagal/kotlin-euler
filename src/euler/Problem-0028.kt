package euler.problem0028

import euler.iterators.range
import euler.replicate
import euler.scanLeft
import euler.sum

fun main(args: Array<String>) {
  val size = 1001

  // average execution time of 0.19694 milliseconds over 50 iterations
  val distances = range(start = 2, increment = 2).takeWhile { it < size }
  val increments = distances.toList().flatMap<Int, Int> { it.replicate(4) }
  val result = increments.scanLeft(1) { (a, b) -> a + b }.sum()

  println("the sum of the numbers on the diagonals in a $size by $size spiral is $result")
}
