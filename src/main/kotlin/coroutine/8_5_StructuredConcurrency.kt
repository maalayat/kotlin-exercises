package coroutine

import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")

    /*
    doSomethingUsefulOne
    doSomethingUsefulTwo
    The answer is 42
    Completed in 1328 ms
    */

    try {
        failedConcurrentSum()
    } catch (exception: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }

    /*
    Second child throws exception
    First child was canceled
    Computation failed with ArithmeticException
    */
}