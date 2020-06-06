package threading.syncronization;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaConcurrency {
    public static void main(String[] args) {
        /**
         * #1 Thread Executors
         *
         * If the number of threads is less than the corePoolSize, create a new Thread to run a new task.
         *
         * If the number of threads is equal (or greater than) the corePoolSize, put the task into the queue.
         *
         * If the queue is full, and the number of threads is less than the maxPoolSize, create a new thread to run tasks in.
         *
         * If the queue is full, and the number of threads is greater than or equal to maxPoolSize, reject the task.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executor executor = (test) -> new Thread(test).start();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MILLISECONDS, null);

        /**
         * #2 Concurrent Collections
         */
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "Ritesh");
//        Hashtable
//        Collections.synchronizedMap();

        /**
         * #3 Atomic Variables
         *
         * As discussed above, the primary use of AtomicInteger is when we are in multi-threaded context and
         * we need to perform atomic operations on an int value without using synchronized keyword.
         *
         */
        AtomicInteger atomicInteger = new AtomicInteger(1);

        /**
         * #4 Semaphores
         *
         * Semaphores are used to control access to a shared resource
         * In contrast to simple synchronized blocks a semaphore has an internal counter that is increased each time
         * a thread acquires a lock and decreased each time a thread releases a lock it obtained before.
         * The increasing and decreasing operations are of course synchronized,
         * hence a semaphore can be used to control how many threads pass simultaneously through a critical section.
         */

        //The fairness parameter decides if new threads, which try to acquire a lock, are set at the beginning or at the end of the list of waiting threads
        Semaphore semaphore = new Semaphore(3, true);
//        semaphore.acquire();
//        semaphore.release();

    }
}
