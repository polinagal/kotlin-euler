package euler.problem0032

import euler.isPandigital
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

    val range = IntArray(9, {i -> i+1})
    var products: HashSet<Int> = HashSet();
    for (multiplicand in 1..10000) {
        for (multiplier in 1..10000) {
            var product: Int = multiplicand * multiplier;
            var line:String = product.toString() + multiplicand.toString() + multiplier.toString()
            if (isPandigital(line.toLong(), range)) {
                products.add(product)
            }
        }
    }
    val answer = products.fold(0) {a,b -> a+b}

    println("Answer: $answer")
}

