package euler.problem0032

import euler.toDigits
import java.util.*
import java.lang.System

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */


fun main(args: Array<String>) {

    var startTime = System.currentTimeMillis()
    val range = IntArray(9, {i -> i+1})
    var products: HashSet<Int> = HashSet();
    for (multiplicand in 1..10000) {
        for (multiplier in 1..10000) {
            var product: Int = multiplicand * multiplier;
            var line:String = product.toString() + multiplicand.toString() + multiplier.toString()
            if (isPandigital(java.lang.Long.parseLong(line), range)) {
                products.add(product)
            }
        }
    }
    val answer = products.fold(0) {a,b -> a+b}

    println("Answer: $answer")
    println("elapsed time: "+(System.currentTimeMillis() - startTime)) //takes very long time about 2 mins

}

fun isPandigital (number: Long, range:IntArray) : Boolean {
    var count = IntArray(10)

    val digits = number.toDigits()

    if (digits.size == 1)
        return true
    if (digits.size > 10)
        return false
    digits.forEach {
        if (range.contains(it)) {
            if ( count[it] != 0) //if current digit is in range and was never seen before
                return false
            else count[it] = 1
        } else //if range doesnt contain current digit
            return false
    }
    return true
}