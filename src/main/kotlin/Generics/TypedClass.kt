package Generics

class TypedClass<T : Any>(parameter: T) {
    val t: T = parameter
}

class TypedClass2<T> {
    fun doSomething() {
    }
}

class TypedClass3<out T> {
    fun doSomething() {

    }
}

fun main(args: Array<String>) {
    val t1 = TypedClass<String>("Hello world")
    /*Type argument is not within its bounds.
    Expected:
    Any
    Found:
    String?*/
    //val t2 = TypedClass<String?>(null) //not compile

    val tc1 = TypedClass2<String>()
    /*Type mismatch.
      Required:
      TypedClass2<Any>
      Found:
      TypedClass2<String>*/
    //val tc2: TypedClass2<Any> = tc1 //not compile

    val tc3 = TypedClass3<String>()
    val tc4: TypedClass3<Any> = tc3 //ok

}

//also allowed in funtions
fun <T> typedFuntion(item: T): List<T> {
    return emptyList()
}