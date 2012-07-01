package euler.problem0067

import java.util.List
import java.util.ArrayList
import java.io.File
import euler.max

fun main(args : Array<String>) {
    var prevLine : List<Int> = arrayList(0, 0)
    var currLine : List<Int> = arrayList(0)

    // average execution time of 4.3958 milliseconds over 10 iterations
    File("src/data/Problem-0067.txt").forEachLine(charset = "UTF-8") {
        val values : List<Int> = it.split(" ").map {it.toInt()}

        for (idx in values.indices) {
            currLine.add(values[idx] + Math.max(prevLine[idx], prevLine[idx + 1]))
        }

        currLine.add(0)
        prevLine = currLine
        currLine = arrayList(0)
    }

    println(prevLine.max())
}
