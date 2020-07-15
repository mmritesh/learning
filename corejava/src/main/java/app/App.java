package app;

import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
//        Set<String> words = getWords("i am very very happy");
//        System.out.println(words);

        String src = "I am a good boy", dest = "am a";
        System.out.println(src.indexOf(dest));
    }

    public Set<String> getWords(String input) {
        Set<String> words = new TreeSet<>();
        StringBuilder word = new StringBuilder();

        char[] inputChars = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            if (inputChars[i] != ' ') {
                word.append(inputChars[i]);
            } else {
                words.add(word.toString());
                word = new StringBuilder();
            }
        }
        words.add(word.toString());
        return words;
    }

}
