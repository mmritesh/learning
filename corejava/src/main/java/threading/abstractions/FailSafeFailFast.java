package threading.abstractions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Concurrent Modification: Concurrent Modification in programming means to modify an object concurrently when another
 * task is already running over it.
 */
public class FailSafeFailFast {

    public static void main(String[] args){

        // This iterator supports FailSafe
        Map<String, Integer> map = new ConcurrentHashMap<>();
        addElements(map);
        Iterator<String> it = map.keySet().iterator();
        iterate(it, map);

        //------------

        /**
         * fail-fast iterators use an internal flag called modCount which is updated each time a collection is modified.
         * Fail-fast iterators checks the modCount flag whenever it gets the next value (i.e. using next() method),
         * and if it finds that the modCount has been modified after this iterator has been created,
         * it throws ConcurrentModificationException.
         */
        map = new HashMap<>();
        addElements(map);
        it = map.keySet().iterator();
        iterate(it, map);
    }

    private static void iterate(Iterator<String> it, Map<String, Integer> map) {
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " : " + map.get(key));
            map.put("FIVE", 5);     //This will not be reflected in the Iterator
        }
    }

    private static Map<String, Integer> addElements(Map<String, Integer> map) {
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);
        return map;
    }
}

/**
 * 1
 * Exception
 * Any changes in the collection, such as adding, removing and updating collection during a thread are iterating collection then Fail fast throw concurrent modification exception.
 * The fail-safe collection doesn't throw exception.
 * 2.
 * Type of collection
 * ArrayList and hashmap collection are the examples of fail-fast iterator
 * Fail-Safe: CopyOnWrite and concurrent modification are the examples of a fail-safe iterator
 * 3.
 * Performance and Memory
 * fail-fast : It's work on actual collection instead. So, this iterator doesn't require extra memory and time
 * Fail-Safe:  It's working on a clone of the collection instead of actual collection. It is overhead in terms of time and memory
 * 4.
 * Modifications
 * fail-fast : Iterators don't allow modifications of a collection while iterating over it.
 * Fail-Safe iterators allow modifications of a collection while iterating over it.
 */

/**
 * Note 1(from java-docs): The fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking,
 * impossible to make any hard guarantees in the presence of unsynchronized concurrent modification.
 * Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore, it would be wrong to
 * write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be
 * used only to detect bugs.
 *
 * Note 2 : If you remove an element via Iterator remove() method, exception will not be thrown. However, in case of
 * removing via a particular collection remove() method, ConcurrentModificationException will be thrown. Below code
 * snippet will demonstrate this:
 */