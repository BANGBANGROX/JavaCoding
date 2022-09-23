import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;

    private int maximumScoreUtil(int[] nums, int[] multipliers, int i, int j) {
        if (i == multipliers.length) return 0;

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int n = nums.length;

        int l = nums[j] * multipliers[i] + maximumScoreUtil(nums, multipliers, i + 1, j + 1);
        int r = nums[(n - 1) - (i - j)] * multipliers[i] + maximumScoreUtil(nums, multipliers, i + 1, j);

        return dp[i][j] = Math.max(l, r);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
         dp = new int[nums.length][multipliers.length];

         for (int i = 0; i < nums.length; ++i) {
             Arrays.fill(dp[i], Integer.MAX_VALUE);
         }

         return maximumScoreUtil(nums, multipliers, 0, 0);
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
            int m = sc.nextInt();
            int[] multipliers = new int[m];
            for (int i = 0; i < m; ++i) {
                multipliers[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maximumScore(nums, multipliers));
        }

        sc.close();
    }
}
