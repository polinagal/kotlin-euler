package euler.problem0034

import euler.toDigits

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the
 * factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

fun main(args: Array<String>) {
    var sum = 0;
    val fact  = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)

    /**
     * 9!*7 = 2540160
     * 9!*8 = 2903040
     *
     * so the upper bound of the search range is 2540160
     */

    for (i in 10..2540160) {

        val digits = i.toDigits()

        var tmpSum = digits.fold(0) {sum,next -> sum+fact[next]}

        if (tmpSum == i) {
            sum += tmpSum
            println (tmpSum)
        }
    }
    println ("Answer: $sum")

}