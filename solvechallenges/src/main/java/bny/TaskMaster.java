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
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class TaskMaster {


    public static void main(String[] args) {
        System.out.println(tasks(7, Arrays.asList(1, 2,3,4,6,5), Arrays.asList(7,6,4,1,2,1)));
    }

    // Complete the tasks function below.
    static int tasks(int n, List<Integer> a, List<Integer> b) {
        Map<Integer, Integer> dependancyMap = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        Integer src, dest, result = 0;

        for (int i = 0; i < a.size() ; i++) {
            dependancyMap.put(a.get(i), b.get(i));
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i+1]) {
                src = i + 1;
                dest = dependancyMap.get(src);
                int count = 0;
                while (src != null && (dest == null || count == 0 || !visited[dest])) {
                    visited[src] = true;
                    count++;
                    src = dest;
                    dest = dependancyMap.get(src);
                }
                result += count;
            }
        }
        return result;
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> aTemp = new ArrayList<>();
//
//        IntStream.range(0, aCount).forEach(i -> {
//            try {
//                aTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<Integer> a = aTemp.stream()
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        int bCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> bTemp = new ArrayList<>();
//
//        IntStream.range(0, bCount).forEach(i -> {
//            try {
//                bTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<Integer> b = bTemp.stream()
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        int res = tasks(n, a, b);
//
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
}


/*
static int tasks(int n, List<Integer> a, List<Integer> b) {
        Map<Integer, Integer> dependancyMap = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        Integer src, dest, result = 0;

        for (int i = 0; i < a.size() ; i++) {
            dependancyMap.put(a.get(i), b.get(i));
        }

        for (int i = 0; i < n; i++) {

                src = i + 1;
                dest = dependancyMap.get(i + 1);
                if (dependancyMap.get(dest) == null ||
                        !dependancyMap.get(dest).equals(src) ||
                        (dependancyMap.get(dest).equals(src) && !visited[dest]) ) {
                    result++;
                }
                visited[src] = true;

        }
        return result;

    }
 */