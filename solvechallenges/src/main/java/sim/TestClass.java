package sim;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        Scanner s = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap();
        Integer N = s.nextInt(), a, b, result = 0;    
        for(int i = 0; i < N; i++) {
            a = s.nextInt();
            b = map.get(a);
            map.put(a, b != null ? b+1 : 1);
        }

        for(Integer key : map.keySet()){
            if(map.get(key) %2 == 0) {
                result += key;
            }
        }
        System.out.println(result); 
    }
}


