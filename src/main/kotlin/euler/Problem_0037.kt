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
inline fun String.truncateLeft() = truncate(this) { it.drop(1) }
inline fun String.truncateRight() = truncate(this) { it.dropLast(1) }
inline fun Sequence<String>.allPrimes() = all { parseLong(it).isPrime() }

fun truncate(string: String, reduce: (String) -> String): Sequence<String> =
        sequence(string, { reduce(it).let { if (it.isEmpty()) null else it } })
