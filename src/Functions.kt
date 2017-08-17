import java.util.*
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    /*println(suma(6.4, 3.3))
    println(resta(45.32))
    println(multiplicacion(43.22, 75.33))
    println(esMayorDeEdad(15))
    println(esMayorDeEdad(19))

    val persona = Persona("Alejandro", 32)
    println("${persona.nombre} tiene ${persona.edad} años y es ${persona.esMayorDeEdad}")*/

    val dt = Calendar.getInstance().timeInMillis
    println("EL tiempo en milis $dt")
    //val odt = TimeUnit.DAYS.toMillis(1)
    val odt = TimeUnit.DAYS.toHours(1)
    println("EL tiempo2 en milis $odt")

}

fun suma(a1: Double, a2: Double) : Double {
    return a1 + a2
}

fun resta(a1: Double = 0.0, a2: Double = 10.0) : Double = a1 - a2

fun multiplicacion(a1: Double, a2: Double) = a1 * a2

//fun esMayorDeEdad(edad: Int) = if (edad >= 18) true else false
fun esMayorDeEdad(edad: Int) = edad >= 18
