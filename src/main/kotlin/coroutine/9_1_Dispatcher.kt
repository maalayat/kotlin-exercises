package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * 9. Coroutine context and dispatchers
 */
fun main() = runBlocking<Unit> {

    // context of the parent, main runBlocking coroutine in the main thread
    launch {
        println("main runBlocking: The thread is ${Thread.currentThread().name}")
    }

    /*starts coroutine in the caller thread, but only until the first suspension point.
      After suspension it resumes in the thread that is fully determined by the suspending function that was invoked*/
    launch(Dispatchers.Unconfined) {
        println("Unconfined: The thread is ${Thread.currentThread().name}")
    }

    /*uses shared background pool of threads, so launch(Dispatchers.Default) { ... }
      uses the same dispatcher as GlobalScope.launch { ... } */
    launch(Dispatchers.Default) {
        println("Default: The thread is ${Thread.currentThread().name}")
    }

    /*creates a new thread for the coroutine to run*/
    launch(newSingleThreadContext("myThread")) {
        //very expensive resource
        println("newSingleThreadContext: The thread is ${Thread.currentThread().name}")
    }

    /*
    Unconfined: The thread is main
    Default: The thread is DefaultDispatcher-worker-1
    main runBlocking: The thread is main
    newSingleThreadContext: The thread is myThread
    */
}