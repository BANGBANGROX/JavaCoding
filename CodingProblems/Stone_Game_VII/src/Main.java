import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;

    private int maxScore(int start, int end, int sum, int[] stones) {
        if (start >= end || sum <= 0) return 0;

        if (dp[start][end] != -1) return dp[start][end];

        int ans;

        // Remove the left stone
        ans = sum - stones[start] - maxScore(start + 1, end, sum - stones[start], stones);

        // Remove the right stone
        ans = Math.max(ans, sum - stones[end] - maxScore(start, end - 1, sum - stones[end], stones));

        return dp[start][end] = ans;
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        dp = new int[n][n];


        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = -1;
            }
        }

        return maxScore(0, n - 1, sum, stones);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] stones = new int[n];
            for (int i = 0; i < n; ++i) {
                stones[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.stoneGameVII(stones));
        }

        sc.close();
    }
}
