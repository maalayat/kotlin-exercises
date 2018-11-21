package coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 14. Channels
 * A Channel is conceptually very similar to BlockingQueue.
 * One key difference is that instead of a blocking "put" operation it has a suspending "send",
 * and instead of a blocking "take" operation it has a suspending "receive".
 */
fun main(args: Array<String>) = runBlocking {
    val channel = Channel<Int>()

    launch {
        for (x in 1..5) channel.send(x * x)
        channel.close()// we're done sending
    }
//    repeat(5) {
//        println(channel.receive())
//    }

    // here we print received values using `for` loop (until the channel is closed)
    for (y in channel) println(y)
}