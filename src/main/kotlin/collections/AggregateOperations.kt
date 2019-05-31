package collections

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val list2 = listOf(1, 3, 5, 7, 20)

    /*********** any ******************/
    //si al menos uno coincide
    println(list.any { it % 2 == 0 }) //: true
    println(list.any { it > 10 }) //: false

    /*********** all **************/
    //si todos coinciden
    println(list.all { it < 8 }) //: true
    println(list.all { it % 2 == 0 }) //: false

    /************* count *****************/
    //cuenta cuantos coinciden
    println(list.count { it % 2 == 0 }) //: 3

    /************** fold ****************/
    //Acumula el valor que comienza con un valor inicial y aplica una operación del primer al último elemento de una colección.
    println(list.fold(4) { actual, next -> actual + next }) //: 25

    /**************** foldRight *******************/
    //lo mismo q fold pero inicia desde el ultimo valor al primero
    println(list.foldRight(5) { actual, next -> actual + next }) //:26


    /************** reduce *********************/
    //lo mismo que fold pero sin valor inicial
    println(list.reduce { actual, next -> actual + next }) //: 21

    /****************** forEach *****************/
    list.forEach { print("$it, ") } //: 1, 2, 3, 4, 5, 6,
    println()

    /****************** forEachIndexed ****************/
    list.forEachIndexed { index, value ->
        println("$index al valor $value") //:0 al valor 1
        //:1 al valor 2
        //:2 al valor 3
        //:3 al valor 4
        //:4 al valor 5
        //:5 al valor 6
    }

    /*********************** max *********************/
    println(list.max()) //: 6

    /*********************** maxBy *******************/
    //Devuelve el primer elemento que produce el valor más grande de la función dada o nulo si no hay elementos
    println(list2.maxBy { it % 2 == 0 }) //: 20

    /********************* none **************************/
    println(list.none { it % 7 == 0 }) //: true

    /****************** sumBy ***************************/
    //Devuelve la suma de todos los valores producidos por la función de transformación
    println(list.sumBy { it % 2 }) //: 3


}