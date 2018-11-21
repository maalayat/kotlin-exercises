package interfaces.delegation.pattern.java;

public class C implements I {
    I i = new A();

    @Override
    public void f() {
        i.f();

    }

    @Override
    public void g() {
        i.g();
    }

    void toA() {
        i = new A();
    }

    void toB() {
        i = new B();
    }
}
