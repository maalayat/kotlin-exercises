package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 2. runBlocking to wrap the execution of the main function,
 *    Waiting for a job
 */
fun main(args: Array<String>) = runBlocking {
    // start main coroutine
    val job = launch { doWork() }
    print("Hello, ")
//    delay(2000L) // delaying for 2 seconds to keep JVM alive
    job.join() // wait until child coroutine completes
}

/**
 * suspending function
 */
suspend fun doWork() {
    delay(1000)
    print("world")
}