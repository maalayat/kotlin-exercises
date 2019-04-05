package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 8. Composing suspending functions
 *
 * 8.2 we want to get the answer faster, by doing both concurrently?
 */
fun main() = runBlocking {

    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        delay(700)
        println("Some computation")
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")

    /*
    doSomethingUsefulOne
    Some computation
    doSomethingUsefulTwo
    The answer is 42
    Completed in 1337 ms
    */
}