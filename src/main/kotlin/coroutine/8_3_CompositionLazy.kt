package coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 8. Composing suspending functions
 *
 * 8.3 It starts coroutine only when its result is needed by some await or if a start function is invoked
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        delay(700)
        println("Some computation")
        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")

    /*
    Some computation
    doSomethingUsefulOne
    doSomethingUsefulTwo
    The answer is 42
    Completed in 2048 ms
    */
}