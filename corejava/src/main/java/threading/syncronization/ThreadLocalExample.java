package threading.syncronization;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal threadLocal = new ThreadLocal();
    private final int value;

    public ThreadLocalExample(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ThreadLocalExample(i), "thread-" + i);
            threads[i].start();
        }
    }

    @Override
    public void run() {
        threadLocal.set(value);
        Integer integer = (Integer) threadLocal.get();
        System.out.println("[" + Thread.currentThread().getName() + "]: " + integer);
    }
}