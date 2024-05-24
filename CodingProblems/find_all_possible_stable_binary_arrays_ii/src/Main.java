import java.util.Scanner;

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = (int) 1e9 + 7;
        final long[][][] dp = new long[zero + 1][one + 1][2];
        final long[][] prefixSumZeroDp = new long[zero + 1][one + 1];
        final long[][] prefixSumOneDp = new long[zero + 1][one + 1];

        for (int i = 0; i <= Math.min(zero, limit); ++i) {
            prefixSumZeroDp[i][0] = dp[i][0][0] = 1;
        }

        for (int i = 0; i <= Math.min(one, limit); ++i) {
            prefixSumOneDp[0][i] = dp[0][i][1] = 1;
        }

        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                dp[i][j][0] = prefixSumOneDp[i - 1][j];
                dp[i][j][1] = prefixSumZeroDp[i][j - 1];
                if (i - limit - 1 >= 0) {
                    dp[i][j][0] = (dp[i][j][0] - prefixSumOneDp[i - limit - 1][j] + MOD) % MOD;
                }
                if (j - limit - 1 >= 0) {
                    dp[i][j][1] = (dp[i][j][1] - prefixSumZeroDp[i][j - limit - 1] + MOD) % MOD;
                }
                prefixSumZeroDp[i][j] = (dp[i][j][0] + prefixSumZeroDp[i][j - 1]) % MOD;
                prefixSumOneDp[i][j] = (dp[i][j][1] + prefixSumOneDp[i - 1][j]) % MOD;
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int zero = sc.nextInt();
            int one = sc.nextInt();
            int limit = sc.nextInt();

            System.out.println(new Solution().numberOfStableArrays(zero, one, limit));
        }

        sc.close();
    }
}
