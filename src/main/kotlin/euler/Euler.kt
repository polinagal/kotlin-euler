package euler

import java.io.File
import java.math.BigInteger
import java.util.ArrayList
import java.util.LinkedList

import euler.iterators.zipWith
import euler.iterators.zipWith3

import kotlin.math.plus
import kotlin.math.times

// candidates for kotlin
inline fun Any.toCharList() = toString().iterator().toArrayList()
inline fun Any.toDigits() = toCharList().map { (c: Char) -> Character.getNumericValue(c) }
inline fun Any.isPalindrome() = toCharList() == toCharList().reverse()

inline fun String.fold(seed: Int, operation: (Int, Int) -> Int): Int {
  var accumulator = seed
  for (char in this) accumulator = (operation)(accumulator, char.toInt())
  return accumulator
}

// candidates for kotlin.math
inline fun <T: Number> bigInt(n: T) = BigInteger(n.toString())

inline fun factorial(n: Int, product: BigInteger = bigInt(1)): BigInteger = if (n == 0) product else factorial(n - 1, n * product)
inline fun Int.times(multiplicand: BigInteger) = bigInt(this) * multiplicand

inline fun Int.multipleOf(n: Int) = toLong() multipleOf n
inline fun Long.multipleOf(n: Int) = this % n == 0.toLong()
inline fun BigInteger.multipleOf(n: Int) = this % bigInt(n) == bigInt(0)

inline fun Int.isPrime() = toLong().isPrime()
inline fun Long.isPrime() = this > 1 && smallestPrimeFactor() == null

inline fun Int.numberOfDivisors(): Int = toLong().numberOfDivisors()
inline fun Long.numberOfDivisors(): Int {
  return primeFactors(this).groupBy { it }.values().map { (group: List<Long>) -> group.size() + 1 }.product()
}

inline fun primeFactors(n: Long): List<Long> {
  val primeFactor = n.smallestPrimeFactor()
  return if (primeFactor == null) arrayList(n) else primeFactor + primeFactors(n / primeFactor)
}

inline fun Int.smallestPrimeFactor() = toLong().smallestPrimeFactor()?.toInt()
inline fun Long.smallestPrimeFactor() = 2..Math.sqrt(toDouble()).toLong() find { this % it == 0.toLong() }

// candidates for JavaIterables.kt

// sum
inline fun Array<Int>.sum() = fold(0) { (a, b: Int) -> a + b }
inline fun Array<Float>.sum() = fold(0.toFloat()) { (a, b: Float) -> a + b }
inline fun Array<Double>.sum() = fold(0.toDouble()) { (a, b: Double) -> a + b }
inline fun Array<Long>.sum() = fold(0.toLong()) { (a, b: Long) -> a + b }
inline fun Array<BigInteger>.sum() = fold(bigInt(0)) { (a, b: BigInteger) -> a + b }

inline fun Iterable<Int>.sum() = fold(0) { (a, b: Int) -> a + b }
inline fun Iterable<Float>.sum() = fold(0.toFloat()) { (a, b: Float) -> a + b }
inline fun Iterable<Double>.sum() = fold(0.toDouble()) { (a, b: Double) -> a + b }
inline fun Iterable<Long>.sum() = fold(0.toLong()) { (a, b: Long) -> a + b }
inline fun Iterable<BigInteger>.sum() = fold(bigInt(0)) { (a, b: BigInteger) -> a + b }

inline fun Iterator<Int>.sum() = fold(0) { (a, b) -> a + b }
inline fun Iterator<Float>.sum() = fold(0.toFloat()) { (a, b) -> a + b }
inline fun Iterator<Double>.sum() = fold(0.toDouble()) { (a, b) -> a + b }
inline fun Iterator<Long>.sum() = fold(0.toLong()) { (a, b) -> a + b }
inline fun Iterator<BigInteger>.sum() = fold(bigInt(0)) { (a, b) -> a + b }

// product
inline fun Array<Int>.product() = fold(1) { (a, b: Int) -> a * b }
inline fun Array<Float>.product() = fold(1.toFloat()) { (a, b: Float) -> a * b }
inline fun Array<Double>.product() = fold(1.toDouble()) { (a, b: Double) -> a * b }
inline fun Array<Long>.product() = fold(1.toLong()) { (a, b: Long) -> a * b }
inline fun Array<BigInteger>.product() = fold(bigInt(1)) { (a, b: BigInteger) -> a * b }

inline fun Iterable<Int>.product() = fold(1) { (a, b: Int) -> a * b }
inline fun Iterable<Float>.product() = fold(1.toFloat()) { (a, b: Float) -> a * b }
inline fun Iterable<Double>.product() = fold(1.toDouble()) { (a, b: Double) -> a * b }
inline fun Iterable<Long>.product() = fold(1.toLong()) { (a, b: Long) -> a * b }
inline fun Iterable<BigInteger>.product() = fold(bigInt(1)) { (a, b: BigInteger) -> a * b }

inline fun Iterator<Int>.product() = fold(1) { (a, b) -> a * b }
inline fun Iterator<Float>.product() = fold(1.toFloat()) { (a, b) -> a * b }
inline fun Iterator<Double>.product() = fold(1.toDouble()) { (a, b) -> a * b }
inline fun Iterator<Long>.product() = fold(1.toLong()) { (a, b) -> a * b }
inline fun Iterator<BigInteger>.product() = fold(bigInt(1)) { (a, b) -> a * b }

// max
inline fun Iterator<Int>.max() = fold(0) { (a, b) -> Math.max(a, b) }
inline fun Iterator<Float>.max() = fold(0.toFloat()) { (a, b) -> Math.max(a, b) }
inline fun Iterator<Double>.max() = fold(0.toDouble()) { (a, b) -> Math.max(a, b) }
inline fun Iterator<Long>.max() = fold(0.toLong()) { (a, b) -> Math.max(a, b) }

inline fun Iterable<Int>.max() = fold(0) { (a, b: Int) -> Math.max(a, b) }
inline fun Iterable<Float>.max() = fold(0.toFloat()) { (a, b: Float) -> Math.max(a, b) }
inline fun Iterable<Double>.max() = fold(0.toDouble()) { (a, b: Double) -> Math.max(a, b) }
inline fun Iterable<Long>.max() = fold(0.toLong()) { (a, b: Long) -> Math.max(a, b) }

inline fun Array<Int>.max() = fold(0) { (a, b: Int) -> Math.max(a, b) }
inline fun Array<Float>.max() = fold(0.toFloat()) { (a, b: Float) -> Math.max(a, b) }
inline fun Array<Double>.max() = fold(0.toDouble()) { (a, b: Double) -> Math.max(a, b) }
inline fun Array<Long>.max() = fold(0.toLong()) { (a, b: Long) -> Math.max(a, b) }

// cartesian products

fun <T: Any> Iterable<T>.findTriplet(predicate: (T, T, T) -> Boolean): Triple<T, T, T>? {
  for (a in this) for (b in this) for (c in this) if ((predicate)(a, b, c)) return Triple(a, b, c)
  return null
}

fun <A : Any, B : Any, C : Any> zipWith(f: (A, B) -> C, iterable1: Iterable<A>, iterable2: Iterable<B>): List<C> {
  return zipWith(f, iterable1.iterator(), iterable2.iterator()).toList()
}

fun <A : Any, B : Any, C : Any, D : Any> zipWith3(f: (A, B, C) -> D,
                                                  iterable1: Iterable<A>,
                                                  iterable2: Iterable<B>,
                                                  iterable3: Iterable<C>): List<D> {
  return zipWith3(f, iterable1.iterator(), iterable2.iterator(), iterable3.iterator()).toList()
}

fun <T : Any> Iterable<T>.foldRight1(operation : (T, T) -> T): T {
  val copy = toLinkedList()
  val seed = copy.removeLast()
  return copy.foldRight(seed, operation)
}

/**
 * Returns a list starting with the *initial* value followed by the intermediary result of reducing sequential pairs of elements from left to right
 */
fun <T : Any> Iterable<T>.scanLeft(initial: T, operation: (T, T) -> T): List<T> {
  val result = arrayList<T>(initial)
  forEach { result.add(operation(result.last(), it)) }
  return result
}

// candidates for kotlin.util

inline fun <T: Any> List<T>.rotations(): List<List<T>> {
  val result = arrayList<List<T>>(this)
  val linkedList = LinkedList(this)
  2..size() forEach {
    linkedList.addLast(linkedList.removeFirst())
    result.add(ArrayList(linkedList))
  }
  return result
}

inline fun <T: Any> T.plus(list: List<T>): List<T> {
  val copy = ArrayList(list)
  copy.add(0, this)
  return copy
}

inline fun <T: Any> List<T>.minus(element: T): List<T> {
  val copy = ArrayList(this)
  copy.remove(element)
  return copy
}

// miscellaneous

fun loadRowsFrom(file: File): List<List<Int>> {
  val rows = ArrayList<List<Int>>()
  file.forEachLine(charset = "UTF-8") { rows.add(it.split(" ").map { it.toInt() }) }
  return rows
}

fun <T : Any> T.replicate(n: Int): List<T> {
  val result = ArrayList<T>(n)
  1..n forEach { result.add(this) }
  return result
}
