import java.util.Scanner;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean stop = false;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = m - 1; i >= 0; --i) {
            if (obstacleGrid[i][n - 1] == 1) {
                obstacleGrid[i][n - 1] = 0;
                stop = true;
            }
            if (!stop) obstacleGrid[i][n - 1] = 1;
        }

        stop = false;

        for (int i = n - 2; i >= 0; --i) {
            if (obstacleGrid[m - 1][i] == 1) {
                obstacleGrid[m - 1][i] = 0;
                stop = true;
            }
            if (!stop) obstacleGrid[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
            }
        }

        return obstacleGrid[0][0];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] obstacleGrid = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    obstacleGrid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
        }

        sc.close();
    }
}
