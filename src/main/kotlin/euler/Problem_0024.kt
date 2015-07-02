package euler.problem0024

import euler.iterators.get
import euler.iterators.permutations

fun main(args : Array<String>) {
  val n = 1000000
  val digits = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  // average execution time of 658.7126 milliseconds over 10 iterations
  val result = digits.permutations().elementAt(n - 1).joinToString(separator = "")

  println("the n-th lexicographic permutation of the digits ${digits.joinToString()} is $result where n = $n")
}
