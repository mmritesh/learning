package zemoso;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2147483647, 10000000));
    }
    public static int solution(int N, int K) {
        // write your code in Java SE 8
        int result = 0;

        while (N > 1 && K > 0) {
            if (N % 2 == 0) {
                N /= 2;
                K--;
                result++;
            } else {
                N--;
                result++;
            }
        }

        result += N==0 ? 0 : N-1;
        return result;
    }
}
