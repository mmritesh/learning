package fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Solve {
//    long[] fib = { 1, 1 , 2, 3, 5, 8, 13, 21, 34, 55, 89 };
    static long[] fib = { };


    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter size: ");
            int size = scanner.nextInt();

            fib = new long[size];
            fib[1] = 1;
            fib[0] = 1;

            getFibSeries(size - 1);
            print(fib);

            System.out.println();
        }

    }
    private static long getFibSeries(int n) {
        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = getFibSeries(n-1) + getFibSeries(n-2);
        return fib[n];
    }

    private static boolean isPrime(long num) {
        if (num == 1)
            return false;
        for (long i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static void print(long[] fib) {
        Arrays.stream(fib).forEach(value -> {
            if (isPrime(value)) {
                System.out.print(value + "(Prime) ");
            } else {
                System.out.print(value + " ");
            }
        });
    }
}
