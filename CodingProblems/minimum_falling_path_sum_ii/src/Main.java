import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] grid;
    private int[][] dp;
    private int n;

    private int minFallingPathSumHandler(int i, int j) {
        if (i >= n) return 0;

        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int result = Integer.MAX_VALUE;

        for (int col = 0; col < n; ++col) {
            if (col != j) {
                result = Math.min(result, minFallingPathSumHandler(i + 1, col) + grid[i][col]);
            }
        }

        return dp[i][j] = result;
    }

    public int minFallingPathSum(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        if (n == 1) return grid[0][0];

        dp = new int[n][n];
        int answer = Integer.MAX_VALUE;

        for (int[] innerDp : dp) {
            Arrays.fill(innerDp, Integer.MIN_VALUE);
        }

        for (int col = 0; col < n; ++col) {
            answer = Math.min(answer, minFallingPathSumHandler(0, col));
        }

        return answer;
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

            System.out.println(new Solution().minFallingPathSum(grid));
        }

        sc.close();
    }
}
