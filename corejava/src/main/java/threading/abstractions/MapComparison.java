package threading.abstractions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class MapComparison implements Runnable {
        /**
         * 1. Concurrent HashMap:
         *  If the level of concurrency required is not specified then it is takes 16 as the default value.
         *  So internally the ConcurrentHashMap will be divided into 16 segments. Each Segment behaves independently.
         *  Creates a new, empty map with a default initial capacity (16), load factor (0.75) and concurrencyLevel (16).
         *  the lock is only on one of the segments.
         *
         *  2. Synchronized HashMap:
         *  In synchronizedMap every write operation acquires lock on entire SynchronizedMap
         */
        private static Map<Integer, String> map;
        private Random random = new Random(currentTimeMillis());
        public static void main(String[] args) throws InterruptedException {
                runPerfTest(new Hashtable<>());
                runPerfTest(Collections.synchronizedMap(new HashMap<>()));
                runPerfTest(new ConcurrentHashMap<>());
                runPerfTest(new ConcurrentSkipListMap<>());
        }
        private static void runPerfTest(Map<Integer, String> map) throws InterruptedException {
                MapComparison.map = map;
                fillMap(map);
                ExecutorService executorService = Executors.newFixedThreadPool(10);
                long startMillis = currentTimeMillis();
                for (int i = 0; i < 10; i++) {
                        executorService.execute(new MapComparison());
                }
                executorService.shutdown();
                executorService.awaitTermination(1, TimeUnit.MINUTES);
                System.out.println(map.getClass().getSimpleName() + " took " + (System.currentTimeMillis() - startMillis) + " ms");
        }
        private static void fillMap(Map<Integer, String> map) {
                for (int i = 0; i < 100; i++) {
                        map.put(i, String.valueOf(i));
                }
        }
        public void run() {
                for (int i = 0; i < 100000; i++) {
                        int randomInt = random.nextInt(100);
                        map.get(randomInt);
                        randomInt = random.nextInt(100);
                        map.put(randomInt, String.valueOf(randomInt));
                }
        }
}