package euler.problem0025

import euler.iterators.fibonacciWithIndices

fun main(args : Array<String>) {
  val size = 1000

  // average execution time of 222.8456 milliseconds over 10 iterations
  val term = fibonacciWithIndices().find { it.value.toString().length() == size }!!

  println("the first term in the Fibonacci sequence to contain $size digits is term F(${term.index}) = ${term.value}")
}
