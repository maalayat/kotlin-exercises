package sam;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String args[]) {
        Callable<String> strCallable = () -> "Hola mundo";
        System.out.println(strCallable);
    }
}
