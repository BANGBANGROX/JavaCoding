import java.util.Scanner;

class Solution {
    private int robUtil(int[] nums, int l, int r) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l + 1], dp[0]);

        for (int i = l + 2; i <= r; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[r];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        if (n == 2) return Math.max(nums[0], nums[1]);

        int includeFirst = robUtil(nums, 0, n - 2);
        int includeLast = robUtil(nums, 1, n - 1);

        return Math.max(includeFirst, includeLast);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.rob(nums));

        sc.close();
    }
}
