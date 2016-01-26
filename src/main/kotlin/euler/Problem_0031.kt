package euler.problem0031
/**
 * Problem 31
 * In England the currency is made up of pound and pence and there are
 * eight coins in general circulation:
 *     1p, 2p, 5p, 10p, 20p, 50p, 1 pound (100p) and 2 pounds (200p).
 * It is possible to make ?2 in the following way:
 *     1*1p + 1*50p + 2*20p + 1*5p + 1*2pnds + 3*1pnd
 * How many different ways can 2 pounds be made using any number of coins?
 * used: http://www.algorithmist.com/index.php/Coin_Change
 */

fun main(args: Array<String>)
{
    val values: IntArray = intArrayOf(1, 2, 5, 10, 20, 50, 100, 200)
    println (change(200,values.size-1,values))

}

fun change(target:Int, index:Int,  values:IntArray) :Int {
    if (target == 0) {
        return 1
    }

    if (target < 0) {
        return 0
    }

    if (index < 0 && target >= 1) {
        return 0
    }
    return change(target,index-1,values) + change(target-values[index],index, values)
}
