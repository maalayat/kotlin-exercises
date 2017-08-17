package collections

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6)

    /***************** drop *********************/
    println(list.drop(4)) //: [5, 6]

    /****************** dropWhile ****************/
    println(list.dropWhile { it < 3 }) //: [3, 4, 5, 6]

    /****************** dropWhile ****************/
    println(list.dropLastWhile { it > 4 }) //: [1, 2, 3, 4]

    /********************* filter ****************/
    println(list.filter { it % 2 == 0 }) //: [2, 4, 6]

    /********************* filterNot ****************/
    println(list.filterNot { it % 2 == 0 }) //: [1, 3, 5]


    /*********************** slice ***********************/
    //Devuelve una lista que contiene elementos en índices especificados.
    println(list.slice(listOf(1, 3, 4))) //: [2, 4, 5]

    /*********************** take **********************/
    //retorno los primeros n elementos
    println(list.take(2)) //: [1, 2]

    //retorno los ultimos n elementos
    println(list.takeLast(2)) //: [5, 6]
}
