package sim;/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.*;

class TestClass2 {

    /**
     *  T
     *  N
     *  a1 a2 a3 ... N
     *
     *  find maximum pairs (a,b) such that, b >= 2a.
     */
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int[] inputs;
        for(int i = 0; i< T; i++) {
            int N = s.nextInt();
            int pairs = 0;
            inputs = new int[N];
            for(int j = 0;j < N; j++)  {
                inputs[j] = s.nextInt();
            }
            int found = N-1;
            for(int j = N-1; j >= 0; j--) {
                if (inputs[j] != -1) {
                    int itr = inputs[j] / 2;
                    found = binarySearchKeyOfLowest(inputs, 0, found, itr);
                    if (found != -1) {
                        pairs++;
                        inputs[found] = -1;
                        found--;
                    }
                    inputs[j] = -1;
                }
            }
            System.out.println(pairs);
        }

    }
    private static int binarySearchKeyOfLowest(int[] a, int low, int high, int key) {
        if (high > -1 && a[high] < key) {
            return high;
        }
        if (low < high) {
            int mid = (low + high)/2;
            if (a[mid] == key) {
                return mid;
            }
            if (key > a[mid]) {
                if (mid + 1 < a.length && key < a[mid + 1]) {
                    return mid;
                }
                return binarySearchKeyOfLowest(a, mid + 1, high, key);
            }
            if (mid - 1 > -1 && key > a[mid - 1]) {
                return mid - 1;
            }
            return binarySearchKeyOfLowest(a, low, mid - 1, key);
        }
        return -1;
    }
}

/**
1
5
10 11 12 13 14

1
6
10 20 30 50 100 160

 10 20 30 50 70 80 160 190
 */