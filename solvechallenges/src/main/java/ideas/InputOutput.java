/* 
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* 
   Example file showing how to write a program that reads
   input from `input.txt` in the current directory
   and writes output to `output.txt` in the current directory
*/

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */

class Main {
    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        int numLines = 0;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/ritesh/Documents/personal/solvechallenges/src/main/java/ideas/input.txt")));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("/Users/ritesh/Documents/personal/solvechallenges/src/main/java/ideas/output.txt")));;
            Map<String, String> apiMap = new LinkedHashMap<>(), tmp;
            Map<String, Map<String, String>> appMap = new LinkedHashMap<>();
            String[] words;
            String app, api, version;

            while(in.hasNextLine()) {
                String line = in.nextLine();
                words = line.split(",");
                app = words[0].trim();
                api = words[1].trim();
                version = words[2].trim();
                if (apiMap.get(api) == null || apiMap.get(api).compareTo(version) < 0) {
                    apiMap.put(api, version);
                }
                if (appMap.get(app) == null) {
                    appMap.put(app, new HashMap<>());
                }
                appMap.get(app).put(api, version);
            }

            appMap.forEach((apps, map) -> {
                for (Map.Entry<String, String> entry : apiMap.entrySet()) {
                    String apis = entry.getKey();
                    String versions = entry.getValue();
                    if (map.get(apis) != null && map.get(apis).compareTo(versions) < 0) {
                        output.println(apps);
                        break;
                    }
                }
            });
            output.close();

            /* In this example, we're writing `num_lines` to
               the file `output.txt`.
               You should modify this part of the
               program to write the desired output */

            Map<String, List<String>> map = new HashMap<>();
            new ArrayList<>(map.values());

        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
