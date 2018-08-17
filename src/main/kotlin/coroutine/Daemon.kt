package coroutine

import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * 4. Coroutines are like daemon threads
 */
fun main(args: Array<String>) = runBlocking {
    val job = launch {
        repeat(1000) {
            println("I'm sleeping $it...")
            delay(500L)
        }
    }
    delay(2300) // delay a bit
    println("main: I'm tired of waiting")
    /*  job.cancel()    // cancels the job
        job.join()      // waits for job's completion
    */
    job.cancelAndJoin()
    println("main: Now I cant quit.")
}