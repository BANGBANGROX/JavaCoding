import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int[][] grid;
    private int n;

    private int cherryPickupUtil(int row1, int col1, int row2) {
        int col2 = row1 + col1 - row2;
        int ans;

        if (row1 == n - 1 && col1 == n - 1 && row2 == n - 1) return dp[row1][col1][row2] = grid[row1][col1];

        if (row1 > n - 1 || col1 > n - 1 || row2 > n - 1 || col2 > n - 1) return -1;

        if (grid[row1][col1] == -1 || grid[row2][col2] == -1) return dp[row1][col1][row2] = -1;

        if (dp[row1][col1][row2] != -2) return dp[row1][col1][row2];

        int value1 = cherryPickupUtil(row1 + 1, col1, row2); // down
        int value2 = cherryPickupUtil(row1, col1 + 1, row2); // right
        int value3 = cherryPickupUtil(row1, col1 + 1, row2 + 1); // 2nd right
        int value4 = cherryPickupUtil(row1 + 1, col1, row2 + 1); // 2nd down
        int maxValue = Math.max(value1, Math.max(value2, Math.max(value3, value4)));

        if (maxValue == -1) {
            return dp[row1][col1][row2] = -1;
        }

        if (row1 == row2) ans = grid[row1][col1] + maxValue;
        else ans = grid[row1][col1] + grid[row2][col2] + maxValue;

        grid[row1][col1] = 0;
        grid[row2][col2] = 0;

        return dp[row1][col1][row2] = ans;
    }

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        this.grid = grid.clone();
        dp = new int[n][n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    dp[i][j][k] = -2;
                }
            }
        }

        int ans = cherryPickupUtil(0, 0, 0);

        return ans == -1 ? 0 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.cherryPickup(grid));
        }

        sc.close();
    }
}
