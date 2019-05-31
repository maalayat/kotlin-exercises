package coroutine

import kotlinx.coroutines.*

/**
 * 4. Coroutines are like daemon threads
 */
fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        repeat(1000) {
            println("I'm sleeping $it...")
            delay(500L)
        }
    }
    delay(1500) // delay a bit
    println("main: I'm tired of waiting")
    /*  job.cancel()    // cancels the job
        job.join()      // waits for job's completion
    */
    job.cancelAndJoin()
    println("main: Now I cant quit.")
}