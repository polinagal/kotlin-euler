package euler.problem0030

import euler.toDigits


fun main(args: Array<String>) {
    var sum:Int = 0
    val fifthPow = intArrayOf(0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049)

    /*
     * Число 354294 выбрано в качестве верхней границы, так как
     * 9^5*7 = 413343 (шестизначное число и не подходит)
     * 9^5*6 = 354294
     */

    for (i in 10..354294) {
        val digits = i.toDigits()
        var tmpSum = 0
        digits.forEach {
            tmpSum+=fifthPow[it]
        }

        if (tmpSum == i) {
            sum += tmpSum
            println (tmpSum)
        }
    }

    println ("Answer: $sum")
}