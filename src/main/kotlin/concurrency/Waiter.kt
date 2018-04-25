package concurrency

import java.util.concurrent.CountDownLatch

class Waiter(private val latch: CountDownLatch) : Runnable {

    override fun run() {
        latch.await()
        println("concurrency.Waiter released")
    }
}