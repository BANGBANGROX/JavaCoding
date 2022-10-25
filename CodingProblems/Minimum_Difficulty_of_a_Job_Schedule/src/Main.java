import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[] jobDifficulty;

    private int dfs(int index, int d) {
        final int n = jobDifficulty.length;

        if (index == n) {
            return d == 0 ? 0 : Integer.MAX_VALUE;
        }

        if (dp[index][d] != -1) return dp[index][d];

        int ans = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;

        for (int i = index; i < n; ++i) {
            currentMax = Math.max(currentMax, jobDifficulty[i]);
            int result = dfs(i + 1, d - 1);
            if (result != Integer.MAX_VALUE) {
                ans = Math.min(ans, result + currentMax);
            }
        }

        return dp[index][d] = ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;
        int n = jobDifficulty.length;

        if (d > n) return -1;

        dp = new int[n][d + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, d);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] jobDifficulty = new int[n];
            for (int i = 0; i < n; ++i) {
                jobDifficulty[i] = sc.nextInt();
            }
            int d = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minDifficulty(jobDifficulty, d));
        }

        sc.close();
    }
}
