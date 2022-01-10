import java.util.Scanner;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (i == n - 1) {
                    dp[i][j] = matrix[i][j];
                    if (i == 0) ans = dp[i][j];
                    continue;
                }
                int value1 = dp[i + 1][j];
                int value2 = (j + 1 < n ? dp[i + 1][j + 1] : Integer.MAX_VALUE);
                int value3 = (j - 1 >= 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE);
                dp[i][j] = matrix[i][j] + Math.min(value1, Math.min(value2, value3));
                if (i == 0) ans = Math.min(ans, dp[i][j]);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            System.out.println(obj.minFallingPathSum(matrix));
        }

        sc.close();
    }
}
