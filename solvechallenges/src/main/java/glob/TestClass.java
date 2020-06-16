package glob;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

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

        // Write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());               // Reading input from STDIN
        String[] input;
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            Department dept = getReference(input[0], input[1]);
            dept.display();
        }

    }

    private static String removeSplChars(String str) {
        return str.replaceAll("[^a-z]", str);
    }
    private static Department getReference(String dept, String name) {
        Department department = null;
        switch(dept) {
            case "Sales": department = new Sales(); break;
            case "ProblemSetter":  department = new ProblemSetter(); break;
            case "Developer":  department = new Developer(); break;
        }
        department.setName(removeSplChars(name));
        return department;
    }
}

interface Department {
    void setName(String name);
    void display();
}

abstract class AbstractDepartment implements Department {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }
}
class ProblemSetter extends AbstractDepartment {
    public void display() {
        System.out.println("ProblemSetter");
        System.out.println("Name: " + this.name);
    }
}

class Sales extends AbstractDepartment {
    public void display() {
        System.out.println("Sales");
        System.out.println("Name: " + this.name);
    }
}

class Developer extends AbstractDepartment {
    public void display() {
        System.out.println("Developer");
        System.out.println("Name: " + this.name);
    }
}