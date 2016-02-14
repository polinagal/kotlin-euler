package euler.problem0043

import euler.isPandigital
import euler.toDigits
import java.util.*

/*
  *
  * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

    Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

    d2d3d4=406 is divisible by 2
    d3d4d5=063 is divisible by 3
    d4d5d6=635 is divisible by 5
    d5d6d7=357 is divisible by 7
    d6d7d8=572 is divisible by 11
    d7d8d9=728 is divisible by 13
    d8d9d10=289 is divisible by 17
    Find the sum of all 0 to 9 pandigital numbers with this property.
 */

fun main(args: Array<String>) {


    //d6 is 5
    //because d4d5d6 is divisible by 5
    //so d6 may be either 5 or 0
    //if d6 were 0 so d6d7d8 would be 0d7d8,
    //that can only be divisible by 11 when d7=d8
    //which is impossible according to the task

    val range = IntArray(10, {i -> i})

    println("Start")
    println("Possible (5) d6d7d8:")
    var d6d7d8: ArrayList<String> = ArrayList()

    (501..598).forEach {
        if (isPandigital(it.toLong(),range) && (it % 11 == 0)) {
            d6d7d8.add(it.toString())
            println(it)
        }
    }

    println("Possible d6d7d8_d9:")
    var d6d7d8d9 = addDigitToEnd(d6d7d8,13)

    println("Possible d6d7d8d9_d10:")
    var d6d7d8d9d10 = addDigitToEnd(d6d7d8d9,17)

    println("Possible d5_d6d7d8d9d10:")
    var d5d6d7d8d9d10 = addDigitToStart(d6d7d8d9d10,7)

    println("Possible d4_d5d6d7d8d9d10:")
    var d4d5d6d7d8d9d10 = addDigitToStart(d5d6d7d8d9d10,5)

    println("Possible d3_d4d5d6d7d8d9d10:")
    var d3d4d5d6d7d8d9d10 = addDigitToStart(d4d5d6d7d8d9d10,3)

    println("Possible d2_d3d4d5d6d7d8d9d10:")
    var d2d3d4d5d6d7d8d9d10 = addDigitToStart(d3d4d5d6d7d8d9d10,2)

    println("Possible d1_d2d3d4d5d6d7d8d9d10:")
    var d1d2d3d4d5d6d7d8d9d10  = addDigitToStart(d2d3d4d5d6d7d8d9d10,1)

    val sum = d1d2d3d4d5d6d7d8d9d10.fold(0L) {a,b -> a.toLong()+b.toLong()}

    println ("Answer: $sum")

}

fun addDigitToStart (searchRange: ArrayList<String>, divisor:Int) : ArrayList<String> {
    val pandigitalRange = IntArray(10, {i -> i})
    var newArrayList:  ArrayList<String> = ArrayList()
    searchRange.forEach {
        val dbdc: String = it[0].toString() +
               it[1].toString()
        for (da in 0..9) {
            val newNumber: String = da.toString() + it
            if (isPandigital(newNumber.toLong(),pandigitalRange) && ((da * 100 + dbdc.toInt()) % divisor == 0)) {
                newArrayList.add(newNumber)
                println(newNumber)
            }
        }
    }
    return newArrayList
}

fun addDigitToEnd (searchRange: ArrayList<String>, divisor:Int) : ArrayList<String> {
    var newArrayList:  ArrayList<String> = ArrayList()
    val pandigitalRange = IntArray(10, {i -> i})
    searchRange.forEach {
        val dadb: String = it.get(it.length - 2).toString() +
                it.get(it.length-1).toString()
        for (dc in 0..9) {
            val newNumber = it + dc.toString()
            if (isPandigital(newNumber.toLong(),pandigitalRange) && ((dadb.toInt() * 10 + dc) % divisor == 0)) {
                newArrayList.add(newNumber)
                println(newNumber)
            }
        }
    }
    return newArrayList
}