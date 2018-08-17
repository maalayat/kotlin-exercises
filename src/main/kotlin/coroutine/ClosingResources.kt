package coroutine

import kotlinx.coroutines.experimental.*

/**
 * 6. Closing resources with finally
 */
fun main(args: Array<String>) = runBlocking {
    val job = launch {
        try {
            repeat(1000) {
                println("I'm sleeping $it ...")
                delay(500L)
            }
        } finally {
            // verify() // call suspend function not terminate work because job finish
            withContext(NonCancellable) {
                verifyAgain()
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can exit.")
}

suspend fun verify() {
    println("try verify...")
    delay(1000)
    println("...verify OK. This line never print because job finished :-(")
}

suspend fun verifyAgain() {
    println("try verify...")
    delay(1000)
    println("...verify OK. Now this line print.")
}