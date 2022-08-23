package interfaces.kotlinform

fun main() {
    val bat = Bat()
    val bird = Bird(AnimalWithWings())

    bat.fly()
    bird.fly()

}
