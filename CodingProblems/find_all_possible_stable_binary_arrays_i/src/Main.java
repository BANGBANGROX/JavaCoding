import java.util.Scanner;

class Solution {
    private long[][][] dp;
    private final int MOD = (int) 1e9 + 7;

    private long numberOfStableArraysHandler(int zero, int one, int limit, int lastDigit) {
        if (zero <= 0 && one <= 0) {
            return 1;
        }

        if (dp[zero][one][lastDigit] != -1) return dp[zero][one][lastDigit];

        long result = 0;

        if (lastDigit == 1) {
            for (int i = 1; i < Math.min(one, limit); ++i) {
                result = (result + numberOfStableArraysHandler(zero, one - i, limit, 0)) % MOD;
            }
        }
        else {
            for (int i = 1; i < Math.min(zero, limit); ++i) {
                result = (result + numberOfStableArraysHandler(zero - i, one, limit, 1)) % MOD;
            }
        }

        return dp[zero][one][lastDigit] = result % MOD;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new long[zero + 1][one + 1][2];

        for (int i = 0; i <= zero; ++i) {
            for (int j = 0; j <= one; ++j) {
                dp[i][j][0] = dp[i][j][1] = -1;
            }
        }

        return (int) ((numberOfStableArraysHandler(zero, one, limit, 1) + numberOfStableArraysHandler(zero, one, limit, 1)) % MOD);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            final int zero = sc.nextInt();
            final int one = sc.nextInt();
            final int limit = sc.nextInt();

            System.out.println(new Solution().numberOfStableArrays(zero, one, limit));
        }

        sc.close();
    }
}
