package threading.syncronization;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NotSynchronizedCounter implements Runnable {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NotSynchronizedCounter(), "thread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }

    public void run() {
        while (counter < 10) {
            synchronized (NotSynchronizedCounter.class){
                System.out.println("[" + Thread.currentThread().getName() + "] ←􏰀 before: " + counter);
                counter++;
                System.out.println("[" + Thread.currentThread().getName() + "] ← 􏰀after:"+counter);
            }

        }
    }
}