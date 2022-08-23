package laziness

fun main() {
    val person = Person("Alejandro Ayala", 33, City("Quito"))

    //aunque no este habilitado, la llamada person.toString() se realiza de cualquier forma
    logEagerly(false, person.toString())

    // en este caso ya no imprime la llamada a person.toString() si el parametro es false
    logLazily(true) {
        person.toString()
    }

    /*
    RESULT:

    =================== EAGERLY FALSE
    >>>>>>>>>>>>>>>>> Call toString function <<<<<<<<<<<<<<<<<<<<<

    Process finished with exit code 0

    =================== EAGERLY TRUE
    >>>>>>>>>>>>>>>>> Call toString function <<<<<<<<<<<<<<<<<<<<<
    The toString of Person class is: laziness.Person[nombre = Alejandro Ayala, edad = 33], ciudad = Quito

    Process finished with exit code 0

    =================== LAZILY FALSE

    Process finished with exit code 0

    =================== LAZILY true
    >>>>>>>>>>>>>>>>> Call toString function <<<<<<<<<<<<<<<<<<<<<
    The toString of Person class is: laziness.Person[nombre = Alejandro Ayala, edad = 33], ciudad = Quito

    Process finished with exit code 0
    * */

}

fun logEagerly(isEnable: Boolean, message: String) {
    when {
        isEnable -> println("The toString of Person class is: $message")
    }
}

fun logLazily(isEnable: Boolean, message: () -> String) {
    when {
        isEnable -> println("The toString of Person class is: ${message()}")
    }
}
