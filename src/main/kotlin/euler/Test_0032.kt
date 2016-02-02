package euler.problem0032

import junit.framework.TestCase
import org.junit.After
import org.junit.Test
import org.junit.Assert
import org.junit.Before

public class Test0032: TestCase() {
    fun testPos1() {
        Assert.assertTrue(isPandigital(123456789))
    }

    fun testPos2() {
        Assert.assertTrue(isPandigital(1234))
    }

    fun testNeg1() {
        Assert.assertFalse(isPandigital(12234))
    }

    fun testNeg2() {
        Assert.assertFalse(isPandigital(1234567890))
    }
}