package euler.problem0014

import euler.multipleOf
import euler.plus

fun main(args : Array<String>) {
  val limit = 1000000

  // average execution time of 590.8156 milliseconds over 10 iterations
  val chain = (1..limit).toList().map { Chain(it, lengthOfSequence(it.toLong())) }.max()

  println("the longest chain below $limit starts with ${chain.start} and has ${chain.length} elements:\n${chain.build()}")
}

inline fun lengthOfSequence(n: Long, length: Int = 0): Int {
  return if (n == 1.toLong()) length + 1 else lengthOfSequence(if (n multipleOf 2) (n / 2) else (3 * n + 1), length + 1)
}

data class Chain(val start: Int, val length: Int) {
  fun build() = sequence(start.toLong())

  private fun sequence(n: Long): List<Long> {
    if (n == 1.toLong()) return listOf(n)
    return if (n multipleOf 2) n + sequence(n / 2) else n + sequence(3 * n + 1)
  }
}

inline fun List<Chain>.max() = fold(Chain(0, 0)) { (a, b) -> if (a.length > b.length) a else b }
