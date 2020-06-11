package bny;

import java.util.HashMap;
import java.util.Map;

public class ClosedPaths {

    public static void main(String[] args) {
        System.out.println(closedPaths(649578));
    }
    /*
     * Complete the 'closedPaths' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER number as parameter.
     */

    public static int closedPaths(int number) {
        // Write your code here
        int result = 0, ptr;
        Map<Integer, Integer> closedPathCounts = new HashMap<>();
        closedPathCounts.put(0, 1);
        closedPathCounts.put(4, 1);
        closedPathCounts.put(6, 1);
        closedPathCounts.put(9, 1);
        closedPathCounts.put(8, 2);

        while (number != 0) {
            ptr = number % 10;
            result += closedPathCounts.get(ptr) != null ? closedPathCounts.get(ptr) : 0;
            number /= 10;
        }
        return result;

    }
}
