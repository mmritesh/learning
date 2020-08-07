package ciena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ciena {
    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread() {
            public void run() {
                A.perform();
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            public void run() {
                A.perform();
            }
        };
        t2.start();
    }

}

class A {
    public static synchronized void perform() {
        System.out.println("performing");
    }
}