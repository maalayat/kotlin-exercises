package coroutine

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.coroutineContext

/**
 * 9. Coroutine context and dispatchers
 */
fun main(args: Array<String>) = runBlocking {

    /**
     *  launch { ... } is the same as launch(DefaultDispatcher) { ... },
     *  which is the same as launch(CommonPool) { ... }
     */

    val jobs = arrayListOf<Job>()

    jobs += launch(Unconfined) {
        println("Unconfined: The thread is ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext) {
        println("coroutineContext: The thread is ${Thread.currentThread().name}")
    }
    jobs += launch(CommonPool) {
        println("CommonPool: The thread is ${Thread.currentThread().name}")
    }
    jobs += launch(newSingleThreadContext("myThread")) {
        //very expensive resource
        println("newSingleThreadContext: The thread is ${Thread.currentThread().name}")
    }

    jobs.forEach { it.join() }
}