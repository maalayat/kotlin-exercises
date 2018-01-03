fun main(args: Array<String>) {

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
    println("Befor execution function")
    func()
    println("After execution function")
}

fun logExecutionParams(func: (String, String) -> Int) {
    println("Befor execution function params")
    val entero = func("Hola", "mundo")
    println("After execution function params the value is $entero")
}

//ejecutar una funcion en un hilo separado
fun runAsync(func: () -> Unit) {
    Thread(Runnable { func() }).start()
}

/*
fun isLollipopOrAbove(func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        func()
    }
}*/
