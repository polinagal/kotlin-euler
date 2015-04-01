package euler.problem0026

import euler.bigInt
import euler.iterators.primes

fun main(args : Array<String>) {
  val limit = 1000

  // see http://en.wikipedia.org/wiki/Repeating_decimal#Fractions_with_prime_denominators
  fun periodOfRepeatingDecimalInTheInverseOf(denominator: Long): Fraction {
    val period = 1..limit find { bigInt(10).modPow(bigInt(it), bigInt(denominator)) == bigInt(1) }
    return Fraction(denominator, period ?: 1)
  }

  // average execution time of 47.3446 milliseconds over 10 iterations
  val result = primes().takeWhile { it < limit }.map { periodOfRepeatingDecimalInTheInverseOf(it) }.max()

  println("the value of d < $limit for which 1/d contains the longest recurring cycle in its decimal fraction part is ${result.denominator} which has a period of ${result.period}")
}

data class Fraction(val denominator: Long, val period: Int)

inline fun Iterator<Fraction>.max() = fold(Fraction(0.toLong(), 0)) { a, b -> if (a.period > b.period) a else b }
