package interfaces

class SimpleClass() : SimpleInterface {

    override val firtsProp:String = "Firts property"

    override fun firstMethod(): String = ("Hello from $firtsProp")
    override val secondProp: String
        get() = super.secondProp

    override fun secondMethod(): String {
        return super.secondMethod()
    }
}