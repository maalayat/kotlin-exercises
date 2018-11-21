package interfaces

interface SimpleInterface {
    val firtsProp: String

    val secondProp: String
        get() = "Second property"

    fun firstMethod(): String

    fun secondMethod(): String {
        return "Hola mundo"
    }

    /**
     * properties in an interface cannot maintain state
     */


    //property initializers are not allowed in interfaces
    //val fistProp:String = "first prop"
}