package asimily;

import java.math.BigInteger;

public class CountPaths {

    private static long count;

    public static void main(String[] args) {
        int di = 10, dj = 10;
        System.out.println("Mathematical Solution: " + countPath1(0, 0, di, dj));
        try {
            countPath2(0, 0, di, dj);
            System.out.println("DFS solution: " + count);
        } catch (StackOverflowError e) {
            System.out.println("DFS Solution: Stack overflow..!");
        }

    }

    /**
     * This solution uses the permutation and combination theory,
     * At the end of the day, for destination at m, n, the iterations has to go `m` times horizontally and `n` times vertically.
     * We need all the permutations of m and n without repetition.
     * this should result in  (m+n)! / (m! * n!)
     * @return
     */
    private static BigInteger countPath1(long si, long sj, long di, long dj) {
        long m = Math.min(di - si, dj - sj);
        long n = Math.max(di - si, dj - sj);
        BigInteger result = BigInteger.ONE;
        BigInteger den = BigInteger.ONE;

        for (long i = n + 1; i <= n + m; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            den = den.multiply(i % n != 0 ? BigInteger.valueOf(i).mod(BigInteger.valueOf(n)) : BigInteger.valueOf(m));
        }
        return result.divide(den);
    }


    /**
     * This solution uses the dfs algorithm to reach to destination,
     * once the destination is found it increments the count.
     */
    private static void countPath2(int si, int sj, int di, int dj) {
        if (si > di || sj > dj) {
            return;
        }
        if (si == di && sj == dj) {
            count++;
            return;
        }
        countPath2( si + 1, sj, di, dj);
        countPath2(  si, sj + 1, di, dj);
    }
}
