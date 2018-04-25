package concurrency

import java.util.concurrent.CountDownLatch

fun main(ars: Array<String>) {
    val latch = CountDownLatch(3)

    val waiter = Waiter(latch)
    val decrement = Decrement(latch)

    Thread(waiter).start()
    Thread(decrement).start()

    //Thread.sleep(4000)
}