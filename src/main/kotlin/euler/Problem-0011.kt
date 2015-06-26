package euler.problem0011

import euler.max
import java.io.File
import java.util.ArrayList

fun main(args: Array<String>) {
  val matrix = Matrix(20)

  File("src/main/resources/Problem-0011.txt").forEachLine(charset = "UTF-8") {
    matrix.add(it.split(" ").map { it.toInt() })
  }

  // average execution time of 1.649 milliseconds over 10 iterations
  println("the greatest product of four adjacent numbers in any direction is ${matrix.max { a, b, c, d -> a * b * c * d }}")
}

class Matrix(val size: Int) {

  private val numbers = ArrayList<List<Int>>(size)

  fun add(row: List<Int>) = numbers.add(row)

  // inspired from http://stefanoricciardi.com/2010/09/21/project-euler-problem-11-in-f/
  fun max(operation: (Int, Int, Int, Int) -> Int): Int {
    return arrayOf(
        max(horizontally,    operation),
        max(vertically,      operation),
        max(diagonallyRight, operation),
        max(diagonallyLeft,  operation)
    ).max()
  }

  private val horizontally = { i: Int, j: Int, operation: (Int, Int, Int, Int) -> Int ->
    if (i > size || j + 4 > size) 0
    else operation(numbers[i][j], numbers[i][j + 1], numbers[i][j + 2], numbers[i][j + 3])
  }

  private val vertically = { i: Int, j: Int, operation: (Int, Int, Int, Int) -> Int ->
    if (i + 4 > size || j > size) 0
    else operation(numbers[i][j], numbers[i + 1][j], numbers[i + 2][j], numbers[i + 3][j])
  }

  private val diagonallyRight = { i: Int, j: Int, operation: (Int, Int, Int, Int) -> Int ->
    if (i + 4 > size || j + 4 > size) 0
    else operation(numbers[i][j], numbers[i + 1][j + 1], numbers[i + 2][j + 2], numbers[i + 3][j + 3])
  }

  private val diagonallyLeft = { i: Int, j: Int, operation: (Int, Int, Int, Int) -> Int ->
    if (i - 3 < 0 || j + 4 > size) 0
    else operation(numbers[i][j], numbers[i - 1][j + 1], numbers[i - 2][j + 2], numbers[i - 3][j + 3])
  }

  private fun max(traverser: (Int, Int, (Int, Int, Int, Int) -> Int) -> Int,
                  operation: (Int, Int, Int, Int) -> Int): Int {
    val rows = (0..size - 1).iterator()
    var cols = (0..size - 1).iterator()

    var row = rows.next()

    fun next(): Int? {
      if (rows.hasNext()) {
        if (cols.hasNext()) return traverser(row, cols.next(), operation)
        row = rows.next()
        cols = numbers.indices.iterator()
        return traverser(row, cols.next(), operation)
      }
      return null
    }

    return iterate { next() }.max()
  }
}
