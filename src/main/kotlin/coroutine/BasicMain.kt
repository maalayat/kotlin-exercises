package coroutine

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * 1. Basic coroutine, Bridging blocking and non-blocking worlds
 */
fun main(args: Array<String>) {
    // launch new coroutine in background and continue
    launch {
        delay(1000L)// non-blocking delay for 1 second
        print(" world!") // print after delay
    }
    print("Hello,") // main thread continues while coroutine is delayed
//    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
    runBlocking {
        // blocks the main thread
        delay(2000L) // while we delay for 2 seconds to keep JVM alive
    }
}