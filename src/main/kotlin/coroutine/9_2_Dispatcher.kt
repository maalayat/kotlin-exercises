package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        println("I am in the thread ${Thread.currentThread().name}")
        delay(1000)
        println("After delay in thread ${Thread.currentThread().name}")
    }

    launch {
        println("I am in the thread ${Thread.currentThread().name}")
        delay(1000)
        println("After delay in thread ${Thread.currentThread().name}")
    }
}