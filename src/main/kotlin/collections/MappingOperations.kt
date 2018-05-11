package collections

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val list2 = listOf("a", "b")

    /************************** flatMap ***********************/
    println(list.flatMap { listOf(it, it + 1) }) //: [1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]
    // se necesita [1a, 1b, 2a, 2b, 3a, 3b, 4a, 4b]
    // si usamos dos map?
    println(list.map { m1 -> list2.map { m2 -> "$m1$m2" } }) //:    [[1a, 1b], [2a, 2b], [3a, 3b], [4a, 4b], [5a, 5b], [6a, 6b]]
    println(list.flatMap { m1 -> list2.map { m2 ->  "$m1$m2"} }) //:[1a, 1b, 2a, 2b, 3a, 3b, 4a, 4b, 5a, 5b, 6a, 6b]

    /*************************** groupBy ***************************/
    //Devuelve un mapa de los elementos de la colección original agrupados por el resultado de la función dada
    println(list.groupBy { if (it % 2 == 0) "pares" else "impares" }) //: {impares=[1, 3, 5], pares=[2, 4, 6]}

    /************************** map ******************************/
    println(list.map { it * 2 }) //: [2, 4, 6, 8, 10, 12]

    println(list.mapIndexed { index, it -> index * it }) //: [0, 2, 6, 12, 20, 30]
}