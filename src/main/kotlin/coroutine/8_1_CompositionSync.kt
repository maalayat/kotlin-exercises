package coroutine

import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 8. Composing suspending functions
 *
 * 8.1 We have two suspending functions, first doSomethingUsefulOne and then doSomethingUsefulTwo.
 * The coroutine, just like in the regular code, is sequential by default
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")

    /*
    doSomethingUsefulOne
    doSomethingUsefulTwo
    The answer is 42
    Completed in 2638 ms
    */
}
