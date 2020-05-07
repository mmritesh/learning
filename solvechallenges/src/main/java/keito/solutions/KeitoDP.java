package keito.solutions;

public class KeitoDP {

    public int run(int M, int N, int[][] garden, int si, int sj, int di, int dj) {

        int maxRoses = -1;
        int i, j, k, a, b;

        if (di < si || dj < sj) {
            return garden[si][sj];
        }

        if (garden[si][sj] == -1) {
            return 0;
        }

        for (k = si; k <= di; k++) {
            i = k;
            j = sj;
            while (i >= si && j <= dj) {
                if (garden[i][j] != -1) {
                    a = i - 1 < si  ? 0 : garden[i - 1][j];
                    b = j - 1 < sj  ? 0 : garden[i][j - 1];
                    if ((a == -1 && b == -1) || (a == 0 && b == -1) || (a == -1 && b == 0)) {
                        garden[i][j] = -1;
                    } else {
                        garden[i][j] = garden[i][j] + Math.max(a, b);
                    }
                }
                if (maxRoses < garden[i][j]){
                    maxRoses = garden[i][j];
                }
                i--;
                j++;
            }
        }
        for (k = sj + 1; k <= dj; k++) {
            i = di;
            j = k;
            while (j <= dj && i >= si) {
                if (garden[i][j] != -1) {
                    a = i - 1 < si ? 0 : garden[i-1][j];
                    b = j - 1 < sj ? 0 : garden[i][j-1];
                    if ((a == -1 && b == -1) || (a == 0 && b == -1) || (a == -1 && b == 0)) {
                        garden[i][j] = -1;
                    } else {
                        garden[i][j] = garden[i][j] + Math.max(a, b);
                    }
                }
                if (maxRoses < garden[i][j]){
                    maxRoses = garden[i][j];
                }
                i--;
                j++;
            }
        }

        return maxRoses;
    }
}
