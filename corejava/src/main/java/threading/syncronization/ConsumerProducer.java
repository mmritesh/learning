package threading.syncronization;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * If wait() and notify() were on the Thread instead then each thread would have to know the status of every other thread.
 * How would thread1 know that thread2 was waiting for access to a particular resource? If thread1 needed to call
 * thread2.notify() it would have to somehow find out that thread2 was waiting. There would need to be some mechanism
 * for threads to register the resources or actions that they need so others could signal them when stuff was ready or available.
 */
public class ConsumerProducer {
    private static final Queue<Integer> queue = new ConcurrentLinkedQueue();
    private static final long startMillis = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {
        Thread[] consumerThreads = new Thread[5];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new Thread(new Consumer(), "consumer-" + i);
            consumerThreads[i].start();
        }
        Thread producerThread = new Thread(new Producer(), "producer");
        producerThread.start();
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i].join();
            producerThread.join();
        }


    }

    public static class Consumer implements Runnable {
        public void run() {
            while (System.currentTimeMillis() < (startMillis + 1000000)) {
                synchronized (queue) {
                    try {
                        System.out.println("[" + Thread.currentThread().getName() + "]: Waiting for lock.");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!queue.isEmpty()) {
                    Integer integer = queue.poll();
                    System.out.println("[" + Thread.currentThread().getName() + "]: Got the access, Number is: " + integer);
                } else {
                    System.out.println("[" + Thread.currentThread().getName() + "]: Got the access, Queue is empty.");
                }
            }
        }
    }

    public static class Producer implements Runnable {
        public void run() {
            int i = 0;
            while (System.currentTimeMillis() < (startMillis + 1000000)) {
                System.out.println("[" + Thread.currentThread().getName() + "]: Producing number: " + i);
                queue.add(i++);
                synchronized (queue) {
                    System.out.println("[" + Thread.currentThread().getName() + "]: Notifying waiting thread.");
                    queue.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    queue.notifyAll();
                }
            }
        }
    }

}