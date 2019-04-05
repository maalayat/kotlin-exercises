package coroutine

import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * This programming style with async functions is provided here only for illustration,
 * because it is a popular style in other programming languages.
 *
 * Using this style with Kotlin coroutines is strongly discouraged.
 */
fun main() {
    val time = measureTimeMillis {
        /*
        val one = doSomethingUsefulOne()
        Suspend function 'doSomethingUsefulOne' should be called only from a coroutine or another suspend function
        */
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        val three = somethingUsefulThree()
        /*
        println("The answer is ${one.await() + two.await()}")
        Suspend function 'await' should be called only from a coroutine or another suspend function
        */

        runBlocking {
            println("The answer is ${one.await() + two.await() + three}")
        }

        /*
        doSomethingUsefulOne
        doSomethingUsefulThree
        doSomethingUsefulTwo
        The answer is 179
        Completed in 1384 ms
        */

    }
    println("Completed in $time ms")
}
