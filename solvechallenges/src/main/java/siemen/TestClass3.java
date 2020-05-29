package siemen;/* IMPORTANT: Multiple classes and nested static classes are supported */

// uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
import java.lang.*;

import static java.lang.Integer.parseInt;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass3 {
    public static void main(String args[]) throws Exception {
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

        // Write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        int[][][] f;

        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().split(" ");
            int R = parseInt(in[0]);
            int B = parseInt(in[1]);
            int K = parseInt(in[2]);
            String.valueOf(in[2]);

            f = new int[R][B][2];
            f[1][0][0] = 1;
            f[0][0][0] = 1;
            f[0][0][1] = 1;
            f[0][1][1] = 1;
            process(f, R - 1, B - 1, K);
            System.out.println(f[R - 1][B - 1][0] + f[R - 1][B - 1][1]);
        }

    }

    private static void process(int[][][] f, int r, int b, int K) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 1; k < K; k++) {
                    f[i][j][0] = f[i - (k - 1)][j][1];
                    f[i][j][1] = f[i][j - (k - 1)][0];
                }
            }
        }
    }
}