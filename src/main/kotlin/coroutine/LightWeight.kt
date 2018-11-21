package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 3. Coroutines ARE light-weight
 */
fun main(args: Array<String>) = runBlocking {
    // launches 100K coroutines and after a second, each coroutine prints a dot
    val jobList = List(100_000) {
        launch {
            delay(1000)
            print(".")
        }
    }
    jobList.forEach { it.join() } // wait for all jobs to complete
}