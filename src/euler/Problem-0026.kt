package euler.problem0026

import euler.bigInt
import euler.iterators.primes

fun main(args : Array<String>) {
  val limit = 1000

  // see http://en.wikipedia.org/wiki/Repeating_decimal#Fractions_with_prime_denominators
  fun periodOfRepeatingDecimalInTheInverseOf(d: Long): #(Long, Int) {
    val period = 1..limit find { bigInt(10).modPow(bigInt(it), bigInt(d)) == bigInt(1) }
    #(d, period ?: 1)
  }

  // average execution time of 47.3446 milliseconds over 10 iterations
  val result = primes().takeWhile { it < limit }.map { periodOfRepeatingDecimalInTheInverseOf(it) }.max()

  println("the value of d < $limit for which 1/d contains the longest recurring cycle in its decimal fraction part is ${result._1} which has a period of ${result._2}")
}

inline fun java.util.Iterator<#(Long, Int)>.max() = fold(#(0.toLong(), 0)) { (a, b) -> if (a._2 > b._2) a else b }
