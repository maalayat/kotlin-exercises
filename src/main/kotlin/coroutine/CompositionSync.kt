package coroutine

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 8. Composing suspending functions
 *
 * 8.1 We have two suspending functions, first doSomethingUsefulOne and then doSomethingUsefulTwo.
 * The coroutine, just like in the regular code, is sequential by default
 */
fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")

    /*
    * The answer is 42
    * Completed in 2609 ms
    */
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1300L)
    return 13

}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1300L)
    return 29
}