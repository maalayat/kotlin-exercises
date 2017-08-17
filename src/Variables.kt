import java.util.*

fun main(args: Array<String>) {
    val nombre = "Alejandro"
    val apellido : String = "Ayala"

//    nombre = "Manuel" no compila val es inmutable

    var edad = 13

//    edad = "asdasd" fue inferido a entero no compila

    println("Escribe tu nombre y pulsa enter")
    val input = Scanner(System.`in`)
    val nextLine = input.nextLine()
    val nick = if (nextLine.isEmpty()) "Kotlin" else nextLine
    print("Hola $nick!")
}
