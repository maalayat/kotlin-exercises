fun main() {

    logExecution { println("I'm a function") }

    println()

    logExecutionParams { value1, value2 -> value1.length + value2.length }

    runAsync {
        // i.e.: save something in the Database
    }

    /*isLollipopOrAbove {
        run lollipop specific code safely
    }*/

}

fun logExecution(func: () -> Unit) {
    println("Before execution function")
    func()
    println("After execution function")
}

fun logExecutionParams(func: (String, String) -> Int) {
    println("Before execution function params")
    val integer = func("Hello", "world")
    println("After execution function params the value is $integer")
}

// run a function in a separate thread
fun runAsync(func: () -> Unit) {
    Thread(Runnable { func() }).start()
}

/*
fun isLollipopOrAbove(func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        func()
    }
}*/
