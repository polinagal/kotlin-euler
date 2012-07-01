package euler.iterators

import euler.bigInt
import euler.isPrime
import euler.minus
import euler.plus

import java.io.File
import java.math.BigInteger
import java.util.Iterator
import java.util.List
import java.util.Scanner

import kotlin.math.plus
import kotlin.support.SingleIterator

fun primes(): Iterator<Long> {
  var number = 2.toLong()

  fun nextPrime(): Long {
    while (!number.isPrime()) number++
    val result = number; number++
    return result
  }

  return iterate<Long> { nextPrime() }
}

fun fibonacci(): Iterator<BigInteger> {
  val iterator = fibonacciWithIndices().iterator()
  return iterate<BigInteger> { iterator.next()._2 }
}

fun fibonacciWithIndices(): Iterator<#(Int, BigInteger)> {
  var a = #(0, bigInt(0)); var b = #(1, bigInt(1))

  fun nextFibonacci(): #(Int, BigInteger) {
    val result = #(b._1 + 1, a._2 + b._2); a = b; b = result
    return result
  }

  return iterate<#(Int, BigInteger)> { nextFibonacci() }
}

fun triangles(): Iterator<#(Int, Int)> {
  var n = 0; var sum = 0

  fun nextTriangle(): #(Int, Int) {
    sum += ++n
    return #(n, sum)
  }

  return iterate<#(Int, Int)> { nextTriangle() }
}

/**
 * Produces the [cartesian product](http://en.wikipedia.org/wiki/Cartesian_product#n-ary_product) as a sequence of ordered pairs of elements lazily obtained
 * from two [[Iterable]] instances
 */
fun <T: Any> Iterable<T>.times(other: Iterable<T>): Iterator<#(T, T)> {
  val first = iterator(); var second = other.iterator(); var a: T? = null

  fun nextPair(): #(T, T)? {
    if (a == null && first.hasNext) a = first.next()
    if (second.hasNext) return #(a!!, second.next())
    if (first.hasNext) {
      a = first.next(); second = other.iterator()
      return #(a!!, second.next())
    }
    return null
  }

  return iterate<#(T, T)> { nextPair() }
}

/**
 * Partitions this string into groups of fixed size strings, except the last will be truncated if the elements do not divide evenly
 *
 * *size* the number of characters per group
 */
fun String.grouped(size: Int): Iterator<String> {
  val iterator = iterator()

  fun nextGroup(): String? {
    if (iterator.hasNext) {
      val window = StringBuilder()
      1..size forEach { if (iterator.hasNext) window.append(iterator.next()) }
      return window.toString()
    }
    return null
  }

  return iterate<String> { nextGroup() }
}

/**
 * Groups elements in fixed size blocks by passing a *sliding window* over them, as opposed to partitioning them, as is done in [[grouped()]].
 * The last and the only element will be truncated if there are fewer characters than *size*
 *
 * *size* the number of characters per group
 */
fun String.sliding(size: Int): Iterator<String> {
  val iterator = iterator()
  val window = StringBuilder()

  fun nextWindow(): String? {
    if (window.length() == 0) {
      1..size forEach { if (iterator.hasNext) window.append(iterator.next()) }
      return window.toString()
    }
    return if (iterator.hasNext) window.deleteCharAt(0)?.append(iterator.next()).toString() else null
  }

  return iterate<String> { nextWindow() }
}

fun <T : Any> List<T>.permutations() : Iterator<List<T>> = if (size == 1) SingleIterator(this) else {
  val iterator = iterator()
  var head = iterator.next()
  var permutations = (this - head).permutations()

  fun nextPermutation(): List<T>? = if (permutations.hasNext()) head + permutations.next() else {
    if (iterator.hasNext()) {
      head = iterator.next()
      permutations = (this - head).permutations()
//      nextPermutation() // TODO: raise compiler bug - VerifyError: Accessing value from uninitialized register 4
      head + permutations.next()
    } else null
  }

  iterate { nextPermutation() }
}

fun File.scan(pattern : String = ".*", delimiter: String, encoding: String = "UTF-8"): Iterator<String> {
  val scanner = Scanner(this, encoding)
  scanner.useDelimiter(delimiter)
  return iterate { if (scanner.hasNext(pattern)) scanner.next(pattern) else { scanner.close(); null } }
}

fun <T : Any> java.util.Iterator<T>.get(index: Int): T {
  var size = 0
  while (size < index && hasNext()) { next(); ++size }
  return if (hasNext()) next() else throw IndexOutOfBoundsException("Index $index, Size: $size")
}

fun <A : Any, B : Any, C : Any> zipWith(f: (A, B) -> C,
                                        it1: java.util.Iterator<A>,
                                        it2: java.util.Iterator<B>): java.util.Iterator<C> = iterate {
  if (it1.hasNext() && it2.hasNext()) f(it1.next(), it2.next()) else null
}

fun <A : Any, B : Any, C : Any, D : Any> zipWith3(f: (A, B, C) -> D,
                                                  it1: java.util.Iterator<A>,
                                                  it2: java.util.Iterator<B>,
                                                  it3: java.util.Iterator<C>): java.util.Iterator<D> = iterate {
  if (it1.hasNext() && it2.hasNext() && it3.hasNext()) f(it1.next(), it2.next(), it3.next()) else null
}
