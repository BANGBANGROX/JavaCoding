import java.util.Scanner;

class Solution {
    public int maximalSquare(char[][] matrix) {
          int m = matrix.length;
          int n = matrix[0].length;
          int maxLen = 0;
          int[] dp = new int[n + 1];

          for (int i = 1; i <= m; ++i) {
              int[] newState = new int[n + 1];
              for (int j = 1; j <= n; ++j) {
                  if (matrix[i - 1][j - 1] == '1') {
                      newState[j] = Math.min(dp[j - 1], Math.min(dp[j], newState[j - 1])) + 1;
                      maxLen = Math.max(maxLen, newState[j]);
                  }
              }
              dp = newState;
          }

          return maxLen * maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] matrix = new char[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = sc.next().charAt(0);
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.maximalSquare(matrix));
        }

        sc.close();
    }
}
