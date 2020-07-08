package shiftright;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int maxSpan = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result2.processLogs(logs, maxSpan);

        System.out.println(result);

        bufferedReader.close();
    }
}

class Result2 {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER maxSpan
     */

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        // Write your code here
        List<Employee> employees = new ArrayList<>();

        logs.forEach(string -> {
            String[] emp = string.split(" ");
            Employee employee = employees.stream().filter(employee1 -> employee1.id.equals(emp[0])).findAny().orElse(null);
            if (employee != null) {
                employee.setTime(emp[2], emp[1]);
            } else {
                employee = new Employee(emp[0]);
                employee.setTime(emp[2], emp[1]);
                employees.add(employee);
            }
        });

        TreeSet<Integer> set = new TreeSet<>();
        employees.forEach(emp -> {
            if (emp.signinTime != 0 && emp.signoutTime != 0 && emp.signoutTime - emp.signinTime <= maxSpan) {
                set.add(Integer.parseInt(emp.id));
            }
        });

        return set.stream().map(Object::toString).collect(toList());
    }

}

class Employee {
    String id;
    int signinTime;
    int signoutTime;
    int deltaTime;

    public Employee(String id) {
        this.id = id;
    }

    public void setTime(String type, String time) {
        switch (type) {
            case "sign-in": signinTime = Integer.parseInt(time); break;
            case "sign-out": signoutTime = Integer.parseInt(time); break;
        }
    }


}