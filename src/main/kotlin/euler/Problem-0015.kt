package euler.problem0015

fun main(args : Array<String>) {
  val size = 20

  // average execution time of 0.0178 milliseconds over 10 iterations
  val result = SquareGrid(size).numberOfNonBacktrackingRoutes()

  println("there are $result routes through a $size x $size grid")
}

// see http://blog.functionalfun.net/2008/07/project-euler-problem-15-city-grids-and.html
class SquareGrid(val size: Int) {
  fun numberOfNonBacktrackingRoutes(): Long = pascal(2 * size, size)

  private fun pascal(row: Int, col: Int): Long = if (col == 0) 1 else (row + 1 - col) * pascal(row, col - 1) / col
}
