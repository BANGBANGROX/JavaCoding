import java.util.Scanner;

class Solution {
    public int integerBreak(int n) {
        int[] nums = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; ++i) nums[i] = i + 1;

        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int num : nums) {
                if (num > i) break;
                dp[i] = Math.max(dp[i], num * Math.max(i - num, dp[i - num]));
            }
        }

        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.integerBreak(n));
        }

        sc.close();
    }
}
