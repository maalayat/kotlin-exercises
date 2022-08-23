import java.util.*

fun main() {
    val name = "Alejandro"
    val lastName: String = "Ayala"

//    name = "Manuel" does not compile val is immutable

    var age = 13

//    age = "asdasd" does not compile 'age' is a number

    println("Enter your name and  y press enter")
    val input = Scanner(System.`in`)
    val nextLine = input.nextLine()
    val nick = nextLine.ifEmpty { "Kotlin" }
    print("Hi $nick!")
}
