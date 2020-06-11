package bny;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class FirstRepeatingLetter {

    /*
     * Complete the 'firstRepeatingLetter' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static void main(String[] args) {
        System.out.println(firstRepeatingLetter("absolutebAlderDAsh"));
    }
    public static String firstRepeatingLetter(String s) {
        // Write your code here
        Map<Character, Integer> counts = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            counts.put(c, counts.get(c) != null ? counts.get(c) + 1 : 1);
        }
        for (Character character : counts.keySet()) {
            if (counts.get(character) > 1) {
                return character.toString();
            }
        }
        return null;
    }

}
