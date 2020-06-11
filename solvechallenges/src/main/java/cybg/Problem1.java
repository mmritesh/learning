package cybg;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    public static void main(String[] args) {
        int[] a = {2,3,1,5,4};
        int sum = 100;
        System.out.println(countTriplets(a, sum));
    }

    private static int countTriplets(int a[], int sum) {

        int count = 0, tempSum;
        for (int i = 0; i < a.length; i++) {
            Set<Integer> set = new HashSet<>();
            tempSum = sum - a[i];

            for (int j = i+1; j < a.length; j++) {
                if (set.contains(tempSum - a[j])) {
                    count++;
                    continue;
                }
                set.add(a[j]);
            }

        }
        return count;
    }
}
