package euler

import euler.iterators.primes


public object Primes {
    private val computed = linkedSetOf(2L)
    private var maxComputed: Long = computed.single()

    public fun isPrime(n: Long): Boolean {
        return if (n <= maxComputed) n in computed else n.smallestPrimeFactor() == null
    }

    public fun sequence(): Sequence<Long> =
       computed.asSequence() +
       sequence({ nextPrime(maxComputed) }, { nextPrime(it) }).map { addNext(it); it }


    private fun nextPrime(n: Long): Long {
        var number = n + if (n.isEven()) 1 else 2
        while (!number.isPrime()) number += 2
        return number
    }

    private fun addNext(prime: Long) {
        computed.add(prime)
        maxComputed = Math.max(prime, maxComputed)
    }
}

inline fun Int.isPrime() = toLong().isPrime()
inline fun Long.isPrime() = Primes.isPrime(this)
inline fun Long.isEven() = (this % 2) == 0L

inline fun Int.numberOfDivisors(): Int = toLong().numberOfDivisors()
inline fun Long.numberOfDivisors(): Int {
    return primeFactors(this).groupBy { it }.values().map { group: List<Long> -> group.size() + 1 }.product()
}

fun primeFactors(n: Long): List<Long> {
    val primeFactor = n.smallestPrimeFactor()
    return if (primeFactor == null) listOf(n) else primeFactor + primeFactors(n / primeFactor)
}

inline fun Int.smallestPrimeFactor() = toLong().smallestPrimeFactor()?.toInt()
inline fun Long.smallestPrimeFactor(): Long? {
    val maxPrimeFactor = Math.sqrt(toDouble()).toLong()
    return primes() takeWhile { it <= maxPrimeFactor } firstOrNull { this % it == 0L }
}