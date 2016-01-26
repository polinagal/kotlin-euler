package euler.problem0032

import java.util.HashSet

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */

fun main(args: Array<String>) {
    var answer: Int = 0
    var products: HashSet<Int> = HashSet();

    for (multiplicand in 1..10000) {
        for (multiplier in 1..10000) {
            var product: Int = multiplicand * multiplier;
            var line:String = "" + product + "" + multiplicand + "" + multiplier
            if (isPandigital(java.lang.Long.parseLong(line))) {
                products.add(product)
//                var output:String = ""+product + "="+multiplicand + "*" + multiplier
//                println (output)
            }
        }
    }

    for(product in products) {
        answer += product;
    }

    println("Answer: "+answer);
}

fun isPandigital (number:Long) : Boolean
{
    var size = java.lang.String.valueOf(number).length
    if (size==1)
        return true
    var count = IntArray(9)

    var temp:Long = number
    while (temp!=0L) {
        if (temp%10 == 0L)
            return false
        if (count[(temp % 10 ).toInt()-1] == 1)
            return false
        count[(temp % 10).toInt()-1] = 1
        temp /= 10
    }

    for (it in count) {
        if (it == 0)
            return false
    }
    return true

}