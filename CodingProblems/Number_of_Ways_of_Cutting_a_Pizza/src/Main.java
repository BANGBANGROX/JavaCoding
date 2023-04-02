import java.util.Scanner;

class Solution {
    public int ways(String[] pizza, int k) {
         int m = pizza.length;
         int n = pizza[0].length();
         int[][] apples = new int[m + 1][n + 1];
         int[][][] dp = new int[k][m + 1][n + 1];
         int MOD = (int) 1e9 + 7;

         for (int i = m - 1; i >= 0; --i) {
             for (int j = n - 1; j >= 0; --j) {
                 apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + apples[i + 1][j] +
                         apples[i][j + 1] - apples[i + 1][j + 1];
                 dp[0][i][j] = apples[i][j] > 0 ? 1 : 0;
             }
         }

         for (int remain = 1; remain < k; ++remain) {
             for (int row = 0; row < m; ++row) {
                 for (int col = 0; col < n; ++col) {
                     for (int nextRow = row + 1; nextRow < m; ++nextRow) {
                         if (apples[row][col] - apples[nextRow][col] > 0) {
                             dp[remain][row][col] = (dp[remain][row][col] +
                                     dp[remain - 1][nextRow][col]) % MOD;
                         }
                     }
                     for (int nextCol = col + 1; nextCol < n; ++nextCol) {
                         if (apples[row][col] - apples[row][nextCol] > 0) {
                             dp[remain][row][col] = (dp[remain][row][col] +
                                     dp[remain - 1][row][nextCol]) % MOD;
                         }
                     }
                 }
             }
         }

         return dp[k - 1][0][0];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] pizza = new String[m];
            for (int i = 0; i < m; ++i) {
                pizza[i] = sc.next();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.ways(pizza, k));
        }

        sc.close();
    }
}
