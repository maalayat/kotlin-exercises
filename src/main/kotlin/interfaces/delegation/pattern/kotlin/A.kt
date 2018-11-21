package interfaces.delegation.pattern.kotlin

class A: I {
    override fun f() {
        println("A: haciendo f()")
    }

    override fun g() {
        println("A: haciendo g()")
    }
}