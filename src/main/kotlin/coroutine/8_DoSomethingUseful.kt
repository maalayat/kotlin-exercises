package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne")
    delay(1300L)

    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1300L)
    println("doSomethingUsefulTwo")

    return 29
}

suspend fun concurrentSum() = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }

    one.await() + two.await()
}

suspend fun failedConcurrentSum() = coroutineScope {
    val one = async {
        try {
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was canceled")
        }
    }

    val two = async<Int> {
        println("Second child throws exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}

fun doSomethingUsefulThree(): Int {
    Thread.sleep(1300L)
    println("doSomethingUsefulThree")

    return 137
}

fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

fun somethingUsefulThree() = doSomethingUsefulThree()
