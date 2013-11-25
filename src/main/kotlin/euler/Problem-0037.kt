package euler.problem0037

import euler.isPrime
import euler.sum
import euler.iterators.primes

import java.lang.Long.parseLong

fun main(args : Array<String>) {
  val limit = 11

  // average execution time of 1.7214 seconds over 10 iterations
  val result = primes().takeWhile { it < 1000000 }.filter { it.isTruncatablePrime() }.take(limit).toList()

  println("the sum of the only $limit truncatable primes is sum$result = ${result.sum()}")
}

inline fun Long.isTruncatablePrime() = this > 7 && isLeftTruncatablePrime() && isRightTruncatablePrime()
inline fun Long.isLeftTruncatablePrime() = toString().truncateLeft().allPrimes()
inline fun Long.isRightTruncatablePrime() = toString().truncateRight().allPrimes()
inline fun String.truncateLeft() = truncate(this) { it.substring(1) }
inline fun String.truncateRight() = truncate(this) { it.substring(0, it.length() - 1) }
inline fun Iterator<String>.allPrimes() = all { parseLong(it).isPrime() }

inline fun truncate(string: String, reduce: (String) -> String): Iterator<String> {
  return iterate {
      var current: String? = string
      var tmp = string
      when (tmp.length()) { 0 -> current = null; 1 -> tmp = ""; else -> tmp = (reduce)(tmp) }
      current
  }
}
