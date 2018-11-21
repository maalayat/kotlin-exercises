package coroutine

import kotlinx.coroutines.*

/**
 * 9. Coroutine context and dispatchers
 */
fun main(args: Array<String>) = runBlocking {

    /**
     *  launch { ... } is the same as launch(DefaultDispatcher) { ... },
     *  which is the same as launch(CommonPool) { ... }
     */

    val jobs = arrayListOf<Job>()

    jobs += launch(Dispatchers.Unconfined) {
        println("Unconfined: The thread is ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext) {
        println("coroutineContext: The thread is ${Thread.currentThread().name}")
    }
    // deprecated CommonPool
    jobs += launch(Dispatchers.Default) {
        println("Default: The thread is ${Thread.currentThread().name}")
    }
    jobs += launch(newSingleThreadContext("myThread")) {
        //very expensive resource
        println("newSingleThreadContext: The thread is ${Thread.currentThread().name}")
    }

    jobs.forEach { it.join() }
}