package euler.problem0024

import euler.iterators.get
import euler.iterators.permutations

// run JVM with -Xms2048m -Xmx2048m
fun main(args : Array<String>) {
  val n = 1000000
  val digits = arrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  // average execution time of 3.7016 seconds over 10 iterations
  val result = digits.permutations().get(n - 1).makeString(separator = "")

  println("the n-th lexicographic permutation of the digits ${digits.makeString()} is $result where n = $n")
}
