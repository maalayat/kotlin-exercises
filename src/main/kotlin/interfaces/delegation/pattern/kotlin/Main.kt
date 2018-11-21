package interfaces.delegation.pattern.kotlin

fun main(args: Array<String>) {
    val a = A()
    val b = B()
    C(a).f() //A: haciendo f()
    C(a).g() //A: haciendo g()
    C(b).f() //B: haciendo f()
    C(b).g() //B: haciendo g()
}