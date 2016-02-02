package euler.problem0043

import junit.framework.TestCase
import org.junit.After
import org.junit.Test
import org.junit.Assert
import org.junit.Before

public class Test0043: TestCase() {
    fun testPos1() {
        Assert.assertTrue(isPandigital("0123456789"))
    }

    fun testPos2() {
        Assert.assertTrue(isPandigital("1234"))
    }

    fun testNeg1() {
        Assert.assertFalse(isPandigital("12234"))
    }

    fun testNeg2() {
        Assert.assertFalse(isPandigital("12345678999"))
    }
}