package euler.problem0043

import java.util.*


/**
 * Created by polina on 27/01/2016.
 */

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


    println("Start")
    println("Possible (5) d6d7d8:")
    var d6d7d8: ArrayList<String> = ArrayList()

    for (i in 501..598) {
        if (isPandigital(i.toString()) && (i % 11 == 0)) {
            d6d7d8.add(i.toString())
            println(i)
        }
    }

    println("Possible d6d7d8_d9:")
    var d6d7d8d9: ArrayList<String> = ArrayList()
    for (i in 1..d6d7d8.size) {
        for (d9 in 0..9) {
            val newNumber: String = d6d7d8.get(i - 1) + d9
            if (isPandigital(newNumber) && ((newNumber.toInt() - 5000) % 13 == 0)) {
                d6d7d8d9.add(newNumber)
                println(newNumber)
            }
        }
    }
    println("Possible d6d7d8d9_d10:")
    var d6d7d8d9d10: ArrayList<String> = ArrayList()
    for (i in 1..d6d7d8d9.size) {
        val d8d9: String = d6d7d8d9.get(i - 1).get(2).toString() +
                d6d7d8d9.get(i - 1).get(3).toString()
        for (d10 in 0..9) {
            val newNumber: String = d6d7d8d9.get(i - 1)  + d10
            val newThree:Int = d8d9.toInt() * 10 + d10
            if (isPandigital(newNumber) && ((d8d9.toInt() * 10 + d10) % 17 == 0)) {
                d6d7d8d9d10.add(newNumber)
                println(newNumber)
            }
        }
    }

    println("Possible d5_d6d7d8d9d10:")
    var d5d6d7d8d9d10: ArrayList<String> = ArrayList()
    for (i in 1..d6d7d8d9d10.size) {
        val d6d7: String = d6d7d8d9d10.get(i - 1).get(0).toString() +
                           d6d7d8d9d10.get(i - 1).get(1).toString()
        for (d5 in 0..9) {
            val newNumber:String = d5.toString() + d6d7d8d9d10.get(i - 1)
            if (isPandigital(newNumber) && ((d5 * 100 + d6d7.toInt()) % 7 == 0)) {
                d5d6d7d8d9d10.add(newNumber)
                println(newNumber)
            }
        }
    }
    println("Possible d4_d5d6d7d8d9d10:")
    var d4d5d6d7d8d9d10: ArrayList<String> = ArrayList()
    for (i in 1..d5d6d7d8d9d10.size) {
        val d5d6: String = d5d6d7d8d9d10.get(i - 1).get(0).toString() +
                           d5d6d7d8d9d10.get(i - 1).get(1).toString()
        for (d4 in 0..9 step 2) {
            val newNumber: String = d4.toString() + d5d6d7d8d9d10.get(i - 1)

            if (isPandigital(newNumber) && ((d4 * 100 + d5d6.toInt()) % 5 == 0)) {

                    d4d5d6d7d8d9d10.add(newNumber)
                    println(newNumber)
                }
            }
        }

    println("Possible d3_d4d5d6d7d8d9d10:")
    var d3d4d5d6d7d8d9d10: ArrayList<String> = ArrayList()
    for (i in 1..d4d5d6d7d8d9d10.size) {
        val d4d5: String = d4d5d6d7d8d9d10.get(i - 1).get(0).toString() +
                           d4d5d6d7d8d9d10.get(i - 1).get(1).toString()
        for (d3 in 0..9) {
            val newNumber: String = d3.toString() + d4d5d6d7d8d9d10.get(i - 1)
            if (isPandigital(newNumber) && ((d3 * 100 + d4d5.toInt()) % 3 == 0)) {
                d3d4d5d6d7d8d9d10.add(newNumber)
                println(newNumber)
            }
        }
    }

    println("Possible d2_d3d4d5d6d7d8d9d10:")
    var d2d3d4d5d6d7d8d9d10: ArrayList<String> = ArrayList()
    for (i in 1..d3d4d5d6d7d8d9d10.size) {
        val d4d5: String = d3d4d5d6d7d8d9d10.get(i - 1).get(0).toString() +
                d3d4d5d6d7d8d9d10.get(i - 1).get(1).toString()
        for (d2 in 0..9) {
            val newNumber: String = d2.toString() + d3d4d5d6d7d8d9d10.get(i - 1)
            if (isPandigital(newNumber) && ((d2 * 100 + d4d5.toInt()) % 2 == 0)) {
                d2d3d4d5d6d7d8d9d10.add(newNumber)
                println(newNumber)
            }
        }
    }

    println("Possible d1_d2d3d4d5d6d7d8d9d10:")
    var d1d2d3d4d5d6d7d8d9d10: ArrayList<String> = ArrayList()
    for (i in 1..d2d3d4d5d6d7d8d9d10.size) {

        for (d1 in 0..9) {
            val newNumber: String = d1.toString() + d2d3d4d5d6d7d8d9d10.get(i - 1)
            if (isPandigital(newNumber) ) {
                d1d2d3d4d5d6d7d8d9d10.add(newNumber)
                println(newNumber)
            }
        }
    }
    var sum:Long = 0
    for (i in d1d2d3d4d5d6d7d8d9d10) {
        sum+= i.toLong()
    }

    print ("Answer:\n" +sum)

}

fun isPandigital (number:String) : Boolean
{
    var size = number.length

    if (size > 10)
        return false
    if (size==1)
        return true
    var count = IntArray(10)

    for (i in 1..number.length) {
        if (count[number.get(i-1).toString().toInt()] == 1)
            return false
        count[number.get(i-1).toString().toInt()] = 1
    }
    return true

}
