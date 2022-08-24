package coroutine

import kotlinx.coroutines.*

/**
 * 5. Cancellation and timeouts
 * A coroutine code has to cooperate to be cancellable
 *
 * It continues to print "I'm sleeping" even after cancellation
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 20) { // computation loop, just wastes CPU, it cannot be cancelled
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(500L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
