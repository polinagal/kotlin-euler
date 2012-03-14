package euler.problem0035

import euler.isPrime
import euler.rotations
import euler.toCharList
import euler.sequence.primes

import kotlin.util.all
import kotlin.util.join

fun main(args : Array<String>) {
  val limit = 1000000
  val result = primes().takeWhile { it < limit }.filter { it.isCircularPrime() }.toList()
  println("the ${result.size()} circular primes below $limit are $result")
}

inline fun Long.isCircularPrime() = toCharList().rotations().all { Long.parseLong(it.join("")).isPrime() }
