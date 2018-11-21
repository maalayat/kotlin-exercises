package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 11. Children of a coroutine
 */
fun main(args: Array<String>) = runBlocking {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        //this job launch in a separate context
        val job1 = launch {
            println("job1: I have my own context and execute independently!")
            delay(1000L)
            println("job1: I am not affected by cancellation of the request")
        }

        //this job launch inherits the parent context
        val job2 = launch(coroutineContext) {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000);
            println("job2: I will not execute this line if my parent request is cancelled")
        }
        job1.join()
        job2.join()
    }
    delay(600)
    request.cancel()// cancel processing of the request
    delay(2000)// delay a second to see what happens
    println("main: Who has survived request cancellation?")

    /**
     * job1: I have my own context and execute independently!
     * job2: I am a child of the request coroutine
     * job1: I am not affected by cancellation of the request
     * main: Who has survived request cancellation?
     */
}