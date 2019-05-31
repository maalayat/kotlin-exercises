package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 11. Children of a coroutine
 */
fun main() = runBlocking {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        //this job launch in a separate context
        val job1 = GlobalScope.launch {
//                        launch {
//            println("job1: I run in GlobalScope and execute independently!")
            log("job1: I run in GlobalScope and execute independently!")
            delay(1000L)
//            println("job1: I am not affected by cancellation of the request")
            log("job1: I am not affected by cancellation of the request")
        }

        //this job launch inherits the parent context
        val job2 = launch(coroutineContext) {
//                    launch {
            delay(100)
//            println("job2: I am a child of the request coroutine")
            log("job2: I am a child of the request coroutine")
            delay(1000);
//            println("job2: I will not execute this line if my parent request is cancelled")
            log("job2: I will not execute this line if my parent request is cancelled")
        }
        job1.join()
        job2.join()
    }
    delay(600)
    request.cancel()// cancel processing of the request
    delay(2000)// delay a second to see what happens
//    println("main: Who has survived request cancellation?")
    log("main: Who has survived request cancellation?")

    /*
    job1: I run in GlobalScope and execute independently!
    job2: I am a child of the request coroutine
    job1: I am not affected by cancellation of the request
    main: Who has survived request cancellation?
    */
//    -Dkotlinx.coroutines.debug
    /*
    [DefaultDispatcher-worker-1 @coroutine#3] job1: I run in GlobalScope and execute independently!
    [main @coroutine#4] job2: I am a child of the request coroutine
    [DefaultDispatcher-worker-1 @coroutine#3] job1: I am not affected by cancellation of the request
    [main @coroutine#1] main: Who has survived request cancellation?
    */
}