import java.util.Scanner;

class Solution {
    public int numOfArrays(int n, int m, int k) {
        final int MOD = (int) 1e9 + 7;
        long[][] previousDP = new long[m + 1][k + 1];
        long[][] previousPrefix = new long[m + 1][k + 1];

        for (int i = 1; i <= m; ++i) {
            previousDP[i][1] = 1;
            previousPrefix[i][1] = i;
        }

        for (int i = 2; i <= n; ++i) {
            long[][] dp = new long[m + 1][k + 1];
            long[][] prefix = new long[m + 1][k + 1];
            for (int maxNum = 1; maxNum <= m; ++maxNum) {
                for (int cost = 1; cost <= k; ++cost) {
                    dp[maxNum][cost] = (maxNum * previousDP[maxNum][cost]) % MOD;
                    if (maxNum > 1 && cost > 1) {
                        dp[maxNum][cost] = (dp[maxNum][cost] + previousPrefix[maxNum - 1][cost - 1]) % MOD;
                    }
                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % MOD;
                }
            }
            previousDP = dp;
            previousPrefix = prefix;
        }

        return (int) previousPrefix[m][k];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numOfArrays(n, m, k));
        }

        sc.close();
    }
}
