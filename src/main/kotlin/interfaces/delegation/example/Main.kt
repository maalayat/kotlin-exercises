package interfaces.delegation.example

fun main(args: Array<String>) {
    val anotherClass = AnotherClass()
    DelegationClass(anotherClass).someMethod()
}