package keito.solutions;

import java.util.ArrayList;
import java.util.List;

public class MaximumCost {
    private static int sum;

    public int run(int M, int N, int[][] garden, int si, int sj, int di, int dj) {
        solve(garden,0, 1,3, 3, new ArrayList<>());
        return sum;
    }

    public void solve(int[][] garden, int x1, int y1, int x2, int y2,
                              List<Integer> path) {
        // TODO: validate coordinates
        if (x1 < 0 || x1 >= garden.length || y1 < 0 || y1 >= garden[x1].length) {
            return;
        }
        if (x1 == x2 && y1 == y2) {
            int currSum = path.stream().mapToInt(Integer::intValue).sum();
            MaximumCost.sum = Math.max(MaximumCost.sum, currSum);
            System.out.println(path.toString() + " " + (x1 + "," + y1) + "cost: " + currSum) ;
            return;
        }

        path.add(garden[x1][y1]);
        solve(garden, x1 + 1, y1, x2, y2, path);
        solve(garden, x1, y1 + 1, x2, y2, path);
        path.remove(path.size() - 1);
    }
}