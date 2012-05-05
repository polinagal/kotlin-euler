package euler.problem0042

import java.io.File

fun main(args : Array<String>) {
  // average execution time of 1.7986 milliseconds over 10 iterations
  val words = File("src/euler/Problem-0042.txt").readText(encoding = "UTF-8").substring(1).split("\"(,\")?")
  val triangles = hashSet(*Array<Int>(100) { (0.5 * it * (it + 1)).toInt() })
  val triangleWords = words.filter { triangles.contains(it.wordValue()) }

  println("there are ${triangleWords.size()} triangle words: ${triangleWords.makeString(limit = 20)}")
}

inline fun String.wordValue() : Int {
  var sum = 0
  for (char in this) sum += char - 'A' + 1
  return sum
}
