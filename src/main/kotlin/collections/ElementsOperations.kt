package collections

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    println(list.contains(2)) //: true

    //retorna el elemento del index pasado o IndexOutOfBoundsException
    println(list.elementAt(2)) //: 3

    //retorno el elemento del index o la funcion si IndexOutOfBoundsException
    println(list.elementAtOrElse(9, { it * 2 })) //: 18

    println(list.elementAtOrNull(10)) //: null

    println(list.first { it % 3 == 0 }) //: 3

    println(list.firstOrNull { it % 7 == 0 }) // null

    println(list.indexOfFirst { it % 4 == 0 }) //: 3

    println(list.indexOfLast { it % 2 == 0 }) //: 6


    //last

    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6, 6, 6)
    println(listRepeated.lastIndexOf(6)) //: 8

    //lastOrNull

    //throws exception  NoSuchElementException si no existe el elemento
    println(list.single { it % 5 == 0 }) //: 5

    //singleOrNull


}
