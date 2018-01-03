package interfaces.traditionalform

interface FlyingAnimal {
    val wings: Wings
    fun fly() = wings.move()
}