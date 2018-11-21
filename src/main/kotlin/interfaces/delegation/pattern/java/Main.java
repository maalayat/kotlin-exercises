package interfaces.delegation.pattern.java;

public class Main {

    public static void main(String[] args) {
        C c = new C();
        c.f(); //A: haciendo f()
        c.g(); //A: haciendo g()
        c.toB();
        c.f(); //B: haciendo f()
        c.g(); //B: haciendo g()
    }
}
