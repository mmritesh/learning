package matrix;

public class SpiralOrder {

    public static void main(String[] args) {
        int m = 5, n = 4;

        int[][] matrix = {{1, 2, 3, 16},
                          {4, 5, 6, 17},
                          {7, 8, 9, 18},
                         {10, 11,12,19},
                         {13, 14,15,20}};

        print(matrix, m, n);
    }

    private static void print(int[][] matrix, int m, int n) {
        int[][] travel = {{0,1,n-1}, {1,0,m-1}, {0,-1,0}, {-1,0,1}};
        int dir = 0, i=0, j=0;

        for (int k = 0; k < m*n ; k++) {
            System.out.print(matrix[i][j] + " ");
            if (changeDirection(travel, dir, i, j)) {
                dir = (dir + 1) % 4;
            }
            i += travel[dir][0];
            j += travel[dir][1];
        }
        System.out.println();
    }

    private static boolean changeDirection(int[][] travel, int dir, int i, int j) {
        int bound = travel[dir][2];
        if ((dir == 0 && j == bound) || (dir == 1 && i == bound)) {
            travel[dir][2]--;
            return true;
        } else if ((dir == 2 && j == bound) || (dir == 3 && i == bound)) {
            travel[dir][2]++;
            return true;
        }
        return false;
    }

}
