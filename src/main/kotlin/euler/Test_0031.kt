package euler.problem0031

import junit.framework.TestCase
import org.junit.After
import org.junit.Test
import org.junit.Assert
import org.junit.Before

public class Test0031: TestCase() {
    fun testChangeOK() {
        //let's have 4 as the amount we want to make
        //and [1.2.3] as the available terms#
        //these numbers are chosen because it's easy to
        //manually compute the result and compare with function output
        //(1,1,1,1) (1,1,2) (2,2) (1,3) => 4 total

        val values: IntArray = intArrayOf(1, 2, 3)
        Assert.assertTrue(change(4,values.size-1, values)==4)
    }

}