package concurrency

import java.util.concurrent.CountDownLatch

class Decrement(private val latch: CountDownLatch) : Runnable {
    override fun run() {
        Thread.sleep(1000)
        latch.countDown()
        println("decrement *")

        Thread.sleep(1000)
        latch.countDown()
        println("decrement *")

        Thread.sleep(1000)
        latch.countDown()
        println("decrement *")
    }
}