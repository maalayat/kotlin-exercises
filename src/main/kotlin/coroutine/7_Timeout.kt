package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/**
 * 7. Timeout
 */
fun main() = runBlocking {
    // To cancel coroutine execution its execution time has exceeded some timeout
    withTimeout(1300) {
        repeat(1000) {
            println("I'm sleeping $it...")
            delay(500L)
        }
    }
    /*
    I'm sleeping 0...
    I'm sleeping 1...
    I'm sleeping 2...
    Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1300 ms
	at kotlinx.coroutines.TimeoutKt.TimeoutCancellationException(Timeout.kt:124)
	at kotlinx.coroutines.TimeoutCoroutine.run(Timeout.kt:90)
	at kotlinx.coroutines.EventLoopImplBase$DelayedRunnableTask.run(EventLoop.kt:307)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.kt:116)
	at kotlinx.coroutines.DefaultExecutor.run(DefaultExecutor.kt:68)
	at java.lang.Thread.run(Thread.java:745)*/

    // withTimeoutOrNull function that is similar to withTimeout, but returns null on timeout instead of throwing an exception

    val result = withTimeoutOrNull(1300L) {
        repeat(1000) {
            println("I'm sleeping $it...")
            delay(500L)
        }
        println("Done") // will get cancelled before it produces this result
    }
    println("The result is $result")
    /*
    I'm sleeping 0...
    I'm sleeping 1...
    I'm sleeping 2...
    The result is null
    */

    /* You can wrap the code with timeout in

    try {...} catch (e: TimeoutCancellationException) {...}

    */
}