package glob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    private int a;

    private void inner() {
        B b = new B();
        b.seeOut();
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Arrays.stream(s.split(" ")).forEach(s1 -> System.out.println(s1));
        String str= "This#string%contains^special*characters&.";
        str = str.replaceAll("[^a-z]", " ");
        System.out.println(str);
    }
    private class B {
        private void seeOut() {
            System.out.println(a);
        }
    }
}
