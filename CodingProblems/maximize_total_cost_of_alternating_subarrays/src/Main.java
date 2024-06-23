import java.util.Scanner;

class Solution {
    private long[][] dp;
    private int[] nums;
    private int n;

    private long maximumTotalCostHandler(int idx, int parity) {
        if (idx >= n) return 0;

        if (dp[idx][parity] != Long.MIN_VALUE) return dp[idx][parity];

        long val = parity == 0 ? nums[idx] : -1 * nums[idx];
        long result = val + maximumTotalCostHandler(idx + 1, 1 - parity);
        result = Math.max(result, val + maximumTotalCostHandler(idx + 1, 0));

        return dp[idx][parity] = result;
    }

    public long maximumTotalCost(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new long[n][2];

        for (int i = 0; i < n; ++i) {
            dp[i][0] = dp[i][1] = Long.MIN_VALUE;
        }

        return maximumTotalCostHandler(0, 0);
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

            System.out.println(new Solution().maximumTotalCost(nums));
        }

        sc.close();
    }
}
