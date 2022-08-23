package sam

import java.util.concurrent.Callable

fun main() {
    val strCallable = Callable { "Hola mundo" }
    println(strCallable)

}
