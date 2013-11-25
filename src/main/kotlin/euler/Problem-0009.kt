package euler.problem0009

import euler.findTriplet

fun main(args : Array<String>) {
  val sum = 1000

  // average execution time of 2.4315 seconds over 10 iterations
  val triplet = pythagoreanTripletAddingUpTo(sum)

  val a = triplet.first; val b = triplet.second; val c = triplet.third

  println("the product of the Pythagorean triplet for which a + b + c = $sum is $a * $b * $c = ${a * b * c}")
}

fun pythagoreanTripletAddingUpTo(sum: Int): Triple<Int, Int, Int> {
  val range = Math.sqrt(sum.toDouble()).toInt()..sum
  fun isPythagorean(a: Int, b: Int, c: Int) = (a * a + b * b == c * c) && a < b && b < c
  return range.findTriplet { (a, b, c) -> isPythagorean(a, b, c) && a + b + c == sum }!!
}
