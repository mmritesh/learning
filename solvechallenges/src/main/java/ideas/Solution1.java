package ideas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1 {
    private static final String inputfilepath = "/Users/ritesh/Documents/personal/solvechallenges/src/main/java/ideas/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File myObj = new File(inputfilepath);
        try (Scanner sc = new Scanner(myObj)) {
            while (sc.hasNext()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
        }
    }
}
