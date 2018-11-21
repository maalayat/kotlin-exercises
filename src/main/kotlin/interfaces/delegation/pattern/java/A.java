package interfaces.delegation.pattern.java;

public class A implements I {
    @Override
    public void f() {
        System.out.println("A: haciendo f()");
    }

    @Override
    public void g() {
        System.out.println("A: haciendo g()");
    }
}
