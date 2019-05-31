package coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * 10. Debug
 * Add VM options: -Dkotlinx.coroutines.debug
 */
fun main() = runBlocking {

    val a = async {
        log("I'm calculate a")
        5
    }
    val b = async {
        log("I'm calculate b")
        7
    }
    log("The result is: ${a.await() + b.await()}")

    /*
    [main @coroutine#2] I'm calculate a
    [main @coroutine#3] I'm calculate b
    [main @coroutine#1] The result is: 12
    */


    /******************************************************************
     * 10.1 Job in the context
     ******************************************************************/
    println("My job is ${coroutineContext[Job]}")
    /*
    My job is "coroutine#1":BlockingCoroutine{Active}@1963006a
    */
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")