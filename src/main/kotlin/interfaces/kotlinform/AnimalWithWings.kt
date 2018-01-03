package interfaces.kotlinform

import interfaces.traditionalform.Wings

class AnimalWithWings : CanFly {
    val wings: Wings = Wings()
    override fun fly() {
        wings.move()
    }
}