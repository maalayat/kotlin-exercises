package interfaces.kotlinform

fun main(args: Array<String>) {
    val bat = Bat()
    val bird = Bird(AnimalWithWings())

    bat.fly()
    bird.fly()

}