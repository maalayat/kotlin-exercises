package interfaces.delegation.pattern.kotlin

class B: I {
    override fun f() {
        println("B: haciendo f()")
    }

    override fun g() {
        println("B: haciendo g()")
    }
}