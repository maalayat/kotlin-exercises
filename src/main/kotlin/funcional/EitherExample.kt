package funcional

import org.funktionale.either.*

/**
 * The <code>Either</code> type is an algebraic data type that is formed by two subtypes - Left and Right.
 * Traditionally, Right is used for storing success fully calculated values and Left is used for storing errors.
 *
 * method           description
 * ------------------------------------------
 * isRight          checks whether it’s Right
 * isLeft           checks whether it’s Left
 * left             returns LeftProjection
 * right            returns RightProjection
 * fold             allows to specify what to do in each case
 */
fun main(args: Array<String>) {

    /**************** Dangerous code in Kotlin -> try-catch-finally ****************/
    /*val number: Long = try {
        DangerousServices.queryNextNumber()
    } catch (exception: Exception) {
        exception.printStackTrace()
        60
    }*/
    //println("The generated number is: $number")

    /************************ eitherTry ***************************/
    val number2 = eitherTry { DangerousServices.queryNextNumber() }
    println("===eitherTry fold===")
    number2.fold(
        { error -> println("ERROR: ${error.message}") },
        { result -> println("The generated number2 is: $result") }
    )
    println("===Either fold===")
    val numberE = DangerousServiceEither.queryNextNumber()
    numberE.fold(
        { println("ERROR: ${it.message}") },
        { println("The generated numberE is: $it") }
    )
    println("===eitherTry when===")
    when (numberE) {
        is RightLike -> println("The generate numberE is ${numberE.right().get()}")
        is LeftLike -> println("ERROR: ${numberE.left().get().message}")
    }

    println("===toDisjunction===")
    val mayBeSum = numberE.toDisjunction().flatMap { num1 ->
        number2.toDisjunction().map { num2 -> num1 + num2 }
    }
    mayBeSum.fold(
        { println("ERROR: ${it.message}") },
        { println("The sum is: $it") })
}

/**
 * Fictitious service that works roughly 60% of the time
 */
object DangerousServices {
    fun queryNextNumber(): Long {
        val number = Math.round(Math.random() * 100)
        if (number <= 60) return number
        else throw Exception("The generated number is too big!")

    }
}

object DangerousServiceEither {
    fun queryNextNumber(): Either<Throwable, Long> = eitherTry {
        val number = Math.round(Math.random() * 100)
        if (number <= 60) number
        else throw Exception("The generated number is too big!")
    }
}