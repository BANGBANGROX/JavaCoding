import java.util.Scanner;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        final int MOD = (int) 1e9 + 7;

        dp[0][0] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int l = 1; l <= k && l <= j; ++l) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                }
            }
        }

        return dp[n][target];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numRollsToTarget(n, k, target));
        }

        sc.close();
    }
}
