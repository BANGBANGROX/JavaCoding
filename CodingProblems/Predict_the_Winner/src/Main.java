import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[] nums;

    private int computeScoreDifference(int l, int r) {
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        return dp[l][r] = Math.max(nums[l] - computeScoreDifference(l + 1, r),
                nums[r] - computeScoreDifference(l, r - 1));
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return computeScoreDifference(0, n - 1) >= 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.PredictTheWinner(nums));
        }

        sc.close();
    }
}
