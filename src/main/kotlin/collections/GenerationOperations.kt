package collections


fun main() {
    val listZip = listOf(7, 8)
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)

    //merge
    //println(listRepeated.merge)

    /************************************** zip(merge) ***************************************/
    //zip reemplaza a merge
    //Devuelve una lista de valores construidos a partir de elementos de ambas colecciones con los mismos índices
    // utilizando la función de transformación proporcionada. La lista tiene la longitud de la colección más corta.
    println(list.zip(listRepeated) { it1, it2 -> it1 + it2 }) //: [3, 4, 6, 8, 10, 11]

    /************************************** zip ***************************************/
    //Devuelve una lista de pares construidos a partir de los elementos de ambas colecciones con los mismos índices.
    // La lista tiene la longitud de la colección más corta
    println(list.zip(listZip)) //: [(1, 7), (2, 8)]

    /************************************** partition ***************************************/
    //Divide la colección original en par de colecciones, donde la primera colección contiene elementos
    // para los cuales el predicado devuelve true, mientras que la segunda colección contiene elementos
    // para los cuales el predicado devuelve false.
    println(list.partition { it % 2 == 0 }) //: ([2, 4, 6], [1, 3, 5])

    /************************************** plus ***************************************/
    println(list.plus(listRepeated)) //: [1, 2, 3, 4, 5, 6, 2, 2, 3, 4, 5, 5, 6]
    println(list + listRepeated) //: [1, 2, 3, 4, 5, 6, 2, 2, 3, 4, 5, 5, 6]

    /********************************** unzip *******************************************/
    println(listOf(Pair(1, 3), Pair(2, 4)).unzip()) //:([1, 2], [3, 4])


}
