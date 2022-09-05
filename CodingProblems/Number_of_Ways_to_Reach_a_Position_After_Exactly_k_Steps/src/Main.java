import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;

    private int numberOfWaysUtil(int pos, int endPos, int k) {
        if (k == 0) return pos == endPos ? 1 : 0;

        int dist = Math.abs(pos - endPos);

        if (dist > k)
            return 0;

        if (dp[pos + 2000][k] != -1) return dp[pos + 2000][k];

        final int MOD = (int) 1e9 + 7;

        int ans = (numberOfWaysUtil(pos - 1, endPos, k - 1) +
                numberOfWaysUtil(pos + 1, endPos, k - 1)) % MOD;

        return dp[pos + 2000][k] = ans;
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new int[4005][k + 1];

        for (int i = 0; i < 4005; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return numberOfWaysUtil(startPos, endPos, k);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int startPos = sc.nextInt();
            int endPos = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numberOfWays(startPos, endPos, k));
        }

        sc.close();
    }
}
