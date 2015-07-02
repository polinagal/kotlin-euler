package euler.problem0022

import euler.sum
import java.io.File
import kotlin.test.assertTrue

fun problem(words: List<String>): Int {
    return words.toSortedSet().withIndex().map { it ->
        it.value.toCharArray().filter { it != '"' }.map { it.toInt() - 64 }.sum() * (it.index + 1)
    }.sum()
}

fun main(args: Array<String>) {
    val words = File("src/main/resources/Problem-0022.txt").readText().split(',')

    assertTrue { problem(listOf("COLIN")) == 53 }
    assertTrue { problem(listOf("COLIN", "ABCD", "BCDE")) == 197 }

    val score = problem(words)
    println("Total of all the name scores in the file is $score")
}
