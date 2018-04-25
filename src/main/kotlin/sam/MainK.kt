package sam

import java.util.concurrent.Callable

fun main(array: Array<String>) {
    val strCallable = Callable { "Hola mundo" }
    println(strCallable)

}