package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 2. runBlocking to wrap the execution of the main function,
 *    Waiting for a job
 */
fun main() = runBlocking {
    // start main coroutine
    doWorld()
    println("Done")
}

/**
 * suspending function
 */
suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000)
        println("World 2")
    }

    launch {
        delay(1000)
        println("World 1")
    }
    println("Hello ")

}
