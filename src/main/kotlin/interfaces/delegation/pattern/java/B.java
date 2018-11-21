package interfaces.delegation.pattern.java;

public class B implements I {
    @Override
    public void f() {
        System.out.println("B: haciendo f()");
    }

    @Override
    public void g() {
        System.out.println("B: haciendo g()");
    }
}
