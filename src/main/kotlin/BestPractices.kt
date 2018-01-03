fun main(args: Array<String>) {
    val cadena = "xFunxWithxKotlinx"
    println(cadena.quitarLasXs(cadena))
}

fun String.quitarLasXs(cadena: String) : Int {
    return length - replace("x", "").length
}
