package collections

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6)

    /************************** flatMap ***********************/
    println(list.flatMap { listOf(it, it + 1) }) //: [1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]

    /*************************** groupBy ***************************/
    //Devuelve un mapa de los elementos de la colección original agrupados por el resultado de la función dada
    println(list.groupBy { if (it % 2 == 0) "pares" else "impares" }) //: {impares=[1, 3, 5], pares=[2, 4, 6]}

    /************************** map ******************************/
    println(list.map { it * 2 }) //: [2, 4, 6, 8, 10, 12]

    println(list.mapIndexed { index, it -> index * it }) //: [0, 2, 6, 12, 20, 30]
}