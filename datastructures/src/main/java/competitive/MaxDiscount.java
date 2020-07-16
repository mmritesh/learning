package competitive;

public class MaxDiscount {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(maxDiscount(1000000000, 21, 10000000, 1, 2));
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }
    // 4, 8, 12, 16 = 4 * 2 = 8
    // 3 6 9 15 18 = 5 * 1 = 5
    public static long maxDiscount(int n, int x, int y, int a, int b) {
        int n1 = a >= b ? x : y;
        int n2 = a < b ? x : y;
        long result = 0;
        int lcm = lcm(x, y);
        result += (n/n1) * Math.max(a, b) + (n/n2 - n/lcm) * Math.min(a, b);
        return result;
    }

    private static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
