package coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 15. Buffered channels
 * Unbuffered channels transfer elements when sender and receiver meet each other (aka rendezvous).
 * If send is invoked first, then it is suspended until receive is invoked,
 * if receive is invoked first, it is suspended until send is invoked.
 */
fun main() = runBlocking {
    val channel = Channel<Int>(4)// create buffered channel
    val sender = launch {
        // launch sender coroutine
        repeat(10) {
            println("Sender $it")// print before sending each element
            channel.send(it)// will suspend when buffer is full
        }
    }
    // don't receive anything... just wait....
    delay(1000)
    sender.cancel()
    println("Fin")

}
