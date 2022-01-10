import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int[][] grid;
    private final int[] dy = {-1, 0, 1};
    private int m, n;

    private int cherryPickupUtil(int row, int col1, int col2) {
        if (row == m) return 0;

        if (dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int ans = 0;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int newCol1 = col1 + dy[i];
                int newCol2 = col2 + dy[j];
                if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                    ans = Math.max(ans, cherryPickupUtil(row + 1, newCol1, newCol2));
                }
            }
        }

        if (col1 == col2) ans += grid[row][col1];
        else ans += (grid[row][col1] + grid[row][col2]);

        return dp[row][col1][col2] = ans;
    }

    public int cherryPickup(int[][] grid) {
       m = grid.length;
       n = grid[0].length;
       this.grid = grid.clone();
       dp = new int[m][n][n];

       for (int i = 0; i < m; ++i) {
           for (int j = 0; j < n; ++j) {
               for (int k = 0; k < n; ++k) {
                   dp[i][j][k] = -1;
               }
           }
       }

       return cherryPickupUtil(0, 0, n - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; ++i) {
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
