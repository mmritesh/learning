package competitive;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

import random.RandomIntegers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    /**
     * 1
     *  4
     * 1 2 4 3
     * 1 2 3 4
     * @param args
     * @throws Exception
     */
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        int n = 10000;
        Integer[] a1 = RandomIntegers.generateRandom(n).toArray(new Integer[0]);
        Integer[] a2 = RandomIntegers.generateRandom(n).toArray(new Integer[0]);

        System.out.println("Started");
        long starttime = System.currentTimeMillis();
        solveWithInput(n, a1, a2);
        long endtime = System.currentTimeMillis();
        System.out.println("Ended at: " + (endtime - starttime) +" msec");

        // Write your code here

    }
    public static void solveWithInput(int n, Integer[] a1, Integer[] a2) {
        Map<Integer, Integer> map = new HashMap();
        long count = 0;

        for(int j=0; j<n; j++) {
            map.put(a2[j], j);
        }

        for(int x=0; x< n; x++) {
            int p = map.get(a1[x]);
            for(int y=x+1; y< n; y++) {
                int q = map.get(a1[y]);
                for(int z=y+1; q > p && z< n; z++) {
                    int r = map.get(a1[z]);
                    if(r > q) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public void solveWithScan() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int i=0; i<T; i++) {
            int n = s.nextInt();
            Map<Integer, Integer> map = new HashMap();
            int count = 0;

            for(int j=0; j<n; j++) {
                map.put(s.nextInt(), j);
            }
            int[] arr = new int[n];
            for(int k=0; k<n; k++) {
                arr[k] = s.nextInt();
            }

            for(int x=0; x< n; x++) {
                int p = map.get(arr[x]);
                for(int y=x+1; y< n; y++) {
                    int q = map.get(arr[y]);
                    for(int z=y+1; q > p && z< n; z++) {
                        int r = map.get(arr[z]);
                        if(r > q) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}

