package euler.problem0034

/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the
 * factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

fun main(args: Array<String>) {
    var sum:Int = 0;
    val fact:IntArray = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)

    /*
     * число 2540161 выбрано в качестве верхней границы поиска,
     * так как оно является максимально возможной суммой факториалов
     * семизначного числа 9!*7=2540160, а 9!*8 = 2903040,
     * что тоже является семизначным числом и не подходит.
     */

    for (i in 10..2540160) {
        var tmp: Int = i
        var tmpSum:Int = 0

        while (tmp>0) {
            tmpSum += fact[tmp%10]
            tmp /= 10
        }
        if (tmpSum == i) {
            sum += tmpSum
            println (tmpSum)
        }
    }
    println ("Answer:" + sum)

}