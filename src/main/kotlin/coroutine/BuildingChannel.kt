package coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/**
 * 14.1 Building Channels
 */
fun main(args: Array<String>) = runBlocking {
    val squares = produceSquares()
    squares.consumeEach { println(it) }
}

fun CoroutineScope.produceSquares() = produce<Int> {
    for (x in 1..5) send(x * x)
}