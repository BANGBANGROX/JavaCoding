import java.util.Scanner;

class Solution {
    public int countVowelPermutation(int n) {
         final int MOD = (int)1e9 + 7;
         long[][] dp = new long[n][5];
         int[][] validMappings = {{1, 2, 4}, {0, 2}, {1, 3}, {2}, {2, 3}};
         long ans = 0;

         for (int i = 0; i < 5; ++i) {
             dp[0][i] = 1;
         }

         for (int i = 1; i < n; ++i) {
             for (int j = 0; j < 5; ++j) {
                 for (int k : validMappings[j]) {
                     dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                 }
             }
         }

         for (int i = 0; i < 5; ++i) {
             ans = (ans + dp[n - 1][i]) % MOD;
         }

         return (int)ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countVowelPermutation(n));
        }

        sc.close();
    }
}
