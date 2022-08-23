package interfaces.delegation.example

fun main() {
    val anotherClass = AnotherClass()
    DelegationClass(anotherClass).someMethod()
}
