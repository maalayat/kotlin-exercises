package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 1. Basic coroutine, Bridging blocking and non-blocking worlds
 */
fun main() = runBlocking {
    // launch new coroutine in background and continue
    val job =launch {
        delay(1000L)// non-blocking delay for 1 second
        println(" world!") // print after delay
    }
    print("Hello,") // main thread continues while coroutine is delayed

    job.join()
    println("Done")

}
