package euler.problem0004

import euler.isPalindrome
import euler.iterators.times

fun main(args : Array<String>) {
  // average execution time of 245.5814 milliseconds over 10 iterations
  val result = (100..999).palindromes().max()

  val multiplier = result.first; val multiplicand = result.second; val product = result.third

  println("the largest palindrome made from the product of two 3-digit numbers is $multiplier x $multiplicand = $product")
}

inline fun IntRange.palindromes() = (this * this).map { Triple(it.first, it.second, it.first * it.second) }.filter { it.third.isPalindrome() }

inline fun Iterator<Triple<Int, Int, Int>>.max() = fold(Triple(0, 0, 0)) { (a, b) -> if (Math.max(a.third, b.third) == a.third) a else b }
