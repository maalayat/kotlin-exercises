package functionTypes

fun main(args: Array<String>) {
    // lambda, complete declaration
    val stringPlus: (value1: String, value2: String) -> String = { value1, value2 -> value1.plus(value2) }
    val stringPlus2: (String, String) -> String = { value1, value2 -> value1.plus(value2) }

    // lambda, function type
    val stringPlus3: (String, String) -> String = String::plus

    println(stringPlus3("Hello ", "world!"))

    val intPlus: (Int, Int) -> Int = Int::plus
    println(intPlus(2, 3))

    //extended function
    val intPlus2: Int.(Int) -> Int = Int::plus
    println(2.intPlus2(3))

    val intFunction: (Int) -> Int = IntTransformer()
    println(intFunction(2))
}


