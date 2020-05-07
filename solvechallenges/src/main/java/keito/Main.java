package keito;

import keito.solutions.KeitoDP;
import keito.solutions.KeitoRecursive;
import keito.solutions.MaximumCost;

public class Main {

    private static final String SAPARATOR = "============================";

    public static void main(String[] args) {
        int[][] garden = {
                {2, 1, 2, 1},
                {8, 2, 3, 4},
                {1,-1, 3,-1},
                {-1, 2,-1, 2},
                {3, 4,-1,-1}
        };
        int M = 5, N = 4;

        KeitoDP keitoDP = new KeitoDP();
        KeitoRecursive keitoRecursive = new KeitoRecursive();
        MaximumCost maximumCost = new MaximumCost();

        int sum1 = maximumCost.run(M, N, garden,0, 1, 3, 3);
        System.out.println("Solution 1:= " + sum1);
        System.out.println(SAPARATOR);

        int sum2 = keitoDP.run(M, N, garden,0, 1,3, 3);
        System.out.println("Solution 2:= " + sum2);
        System.out.println(SAPARATOR);

        int sum3 =keitoRecursive.run(M, N, garden,0, 1,3, 3);
        System.out.println("Solution 3:= " + sum3);
        System.out.println(SAPARATOR);


    }
}
