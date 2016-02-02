package euler.problem0030


fun main(args: Array<String>) {
    var sum:Int = 0
    val fifthPow:IntArray = intArrayOf(0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049)

    /*
     * Число 354294 выбрано в качестве верхней границы, так как
     * 9^5*7 = 413343 (шестизначное число и не подходит)
     * 9^5*6 = 354294
     */

    for (i in 10..354294) {
        var tmp:Int = i
        var tmpSum:Int = 0

        while (tmp>0) {
            tmpSum += fifthPow[tmp%10]
            tmp /= 10
        }
        if (tmpSum == i) {
            sum += tmpSum
            println (tmpSum)
        }
    }

    println ("Answer: " + sum)
}