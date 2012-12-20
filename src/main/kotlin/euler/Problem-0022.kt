package euler.problem0022

import euler.sum
import java.io.File
import kotlin.test.assertTrue

fun problem(words: Array<String>): Int {
    return words.toSortedSet().withIndices().map { pair ->
        pair.second.toCharArray().filter { it != '"' }.map { it.toInt() - 64 }.sum() * (pair.first + 1)
    }.sum()
}

fun main(args: Array<String>) {
    val words = File("src/main/resources/Problem-0022.txt").readText().split(',')

    assertTrue { problem(array("COLIN")) == 53 }
    assertTrue { problem(array("COLIN", "ABCD", "BCDE")) == 197 }

    val score = problem(words)
    println("Total of all the name scores in the file is $score")
}
