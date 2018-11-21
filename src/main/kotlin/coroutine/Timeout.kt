package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/**
 * 7. Timeout
 */
fun main(args: Array<String>) = runBlocking {
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
    Exception in thread "main" kotlinx.coroutines.experimental.TimeoutCancellationException: Timed out waiting for 1300 MILLISECONDS
	at kotlinx.coroutines.experimental.ScheduledKt.TimeoutCancellationException(Scheduled.kt:202)
	at kotlinx.coroutines.experimental.TimeoutCoroutine.run(Scheduled.kt:100)
	at kotlinx.coroutines.experimental.EventLoopBase$DelayedRunnableTask.run(EventLoop.kt:322)
	at kotlinx.coroutines.experimental.EventLoopBase.processNextEvent(EventLoop.kt:148)
	at kotlinx.coroutines.experimental.BlockingCoroutine.joinBlocking(Builders.kt:82)
	at kotlinx.coroutines.experimental.BuildersKt__BuildersKt.runBlocking(Builders.kt:58)
	at kotlinx.coroutines.experimental.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.experimental.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:48)
	at kotlinx.coroutines.experimental.BuildersKt.runBlocking$default(Unknown Source)
	at coroutine.TimeoutKt.main(Timeout.kt:10)*/


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

}