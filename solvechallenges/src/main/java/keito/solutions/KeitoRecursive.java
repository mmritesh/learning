package keito.solutions;

import java.util.ArrayList;
import java.util.List;

public class KeitoRecursive {
    private static int sum = 0;

    public int run(int M, int N, int[][] garden, int si, int sj, int di, int dj) {
        solve(5, 4, garden,0, 1,3, 3, new ArrayList<>());
        return sum;
    }
    private void solve(int M, int N, int[][] garden, int si, int sj, int di, int dj, List<Integer> path) {
        if (si < 0 || si > M - 1 || sj < 0 || sj > N - 1 ){
            return;
        }

        if (si == di && sj == dj) {
            sum = Math.max(sum, path.stream().mapToInt(value -> value).sum());
            System.out.println(path.toString() + "  Cost: " + sum);
            return;
        }

        path.add(garden[si][sj]);
        solve(M, N, garden, si + 1, sj, di, dj, path);
        solve(M, N, garden, si, sj + 1, di, dj, path);
        path.remove(path.size() - 1);
    }
}
