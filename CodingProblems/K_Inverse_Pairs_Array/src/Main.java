import java.util.Scanner;

class Solution {
    public int kInversePairs(int n, int k) {
         if (k == 0) return 1;

         int[][] dp = new int[n + 1][k + 1];
         final int mod = (int)1e9 + 7;

         for (int i = 1; i <= n; ++i) {
             dp[i][0] = 1;
             for (int j = 1; j <= k; ++j) {
                 int value = (dp[i - 1][j] - (j >= i ? dp[i - 1][j - i] : 0) + mod) % mod;
                 dp[i][j] = (dp[i][j - 1] + value) % mod;
             }
         }

         return (dp[n][k] - dp[n][k - 1] + mod) % mod;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.kInversePairs(n, k));
        }

        sc.close();
    }
}
