package euler.problem0042

import euler.iterators.scan
import java.io.File

fun main(args : Array<String>) {
  // average execution time of 4.8289 milliseconds over 10 iterations
  val words = File("src/main/resources/Problem-0042.txt").scan(delimiter = "\"(,\")?")
  val triangles = Array(100) { n -> n * (n + 1) / 2 }.toSet()
  val triangleWords = words.filter { word -> triangles.contains(word.value()) }.toList()

  println("there are ${triangleWords.size()} triangle words: ${triangleWords.joinToString(limit = 20)}")
}

inline fun String.value() = fold(0) { a, b -> a + (b - 'A' + 1) }
