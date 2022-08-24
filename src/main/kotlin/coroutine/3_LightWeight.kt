package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 3. Coroutines ARE light-weight
 */
fun main() = runBlocking {
    // launches 100K coroutines and after a second, each coroutine prints a dot
    repeat(100_000) {
        launch {
            delay(1000)
            println(".")
        }
    }
}
