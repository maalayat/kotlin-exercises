package promises

import nl.komponents.kovenant.functional.bind
import nl.komponents.kovenant.functional.map
import nl.komponents.kovenant.task
import nl.komponents.kovenant.then

/**
 * Kovenant             Promises for Kotlin. The easy asynchronous library for Kotlin. With extensions
 *                      for Android, RxJava, JavaFX and much more.
 *
 * method               description
 * -------------------------------------------------------------------------------------------------
 * always               applies the provided callback when the Promise completes, successfully or not
 * fail                 applies the provided callback when the Promise completes with an exception
 * success              applies the provided callback when the Promise completes successfully
 * isSuccess            checks whether the Promise was completed successfully
 * isFailure            checks whether the Promise was completed with an error
 * get                  waits until Promise completes and returns the value (blocking the thread)
 * then                 allows to transform one Promise into another
 */
fun main(args: Array<String>) {
    /*println("Call to dangerous slow service")
    println("The number is ${DangerousService.querySlowNumber()}")
    println("Finished")*/
    val num1P = task { DangerousService.querySlowNumber() }
    num1P.success {
        println("Promises(num1P)[success]: $it")
    }

    val num2P = task { DangerousService.querySlowNumber() }
    num2P.success {
        println("Promises(num2P)[success]: $it")
    }.fail {
        println("Promises(num2P)[fail]: $it")
    }

    /****************************Promises callbacks ************************************/
    num1P.success { num1 ->
        num2P.success { num2 ->
            println("Sum promises callbacks hell: ${num1 + num2}")
        }
    }

    /*************************** then - success - fail ********************************/
    num1P.then {
        println("Promises(num1P) [then]: [[$it]] ... and now I call dangerous services again blocking the main thread")
        task { DangerousService.querySlowNumber() }
    } success {
        /*it.success {
            println("Promises(DangerousService) [success]: $it")
        }.fail {
            println("Promises(DangerousService) [fail]: $it")
        }*/
        val num3P = it.get()
        println("Promises(get) blocking the main thread: $num3P")

    } fail {
        println("Promises(num1P) [fail]: $it")
    }

    /************************* bind - map **********************************/
    val sum = num1P.bind { num1 -> num2P.map { num2 -> num1 + num2 } }
    sum.success {
        println("Sum with bind and map: (success): $it")
    }.fail {
        println("Sum with bind and map: (fail): $it")
    }

    println("Finished")
}

object DangerousService {
    fun querySlowNumber(): Long {
        Thread.sleep(2000)
        val number = Math.round(Math.random() * 100)
        if (number <= 95) return number
        else throw Exception("The generated number is too big!")
    }
}