package coroutine

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 8. Composing suspending functions
 *
 * 8.2 we want to get the answer faster, by doing both concurrently?
 */
fun main(args: Array<String>) {
    runBlocking {
        val time = measureTimeMillis {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time")
    }
    /*
    * The answer is 42
    * Completed in 1339
    */


    // we don't have `runBlocking`
    val time2 = measureTimeMillis {
        val one = doSomethingUsefulOneAsyn()
        val two = doSomethingUsefulTwoAsync()

        runBlocking {
            println("The answer async is ${one.await() + two.await()}")
        }
    }
    println("Completed async in $time2")
    /**
     * The answer async is 42
     * Completed async in 1304
     */
}

fun doSomethingUsefulOneAsyn() = async {
    delay(1300L)
    13
}

fun doSomethingUsefulTwoAsync() = async {
    delay(1300L)
    29
}