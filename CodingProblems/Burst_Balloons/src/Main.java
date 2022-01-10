import java.util.Scanner;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[][] dp = new int[n][n];
        int[] newNums = new int[n];

        System.arraycopy(nums, 0, newNums, 1, n - 2);

        newNums[0] = 1;
        newNums[n - 1] = 1;

        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = len + i - 1;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.maxCoins(nums));
        }

        sc.close();
    }
}
