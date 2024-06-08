import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] dp;
    private int[] nums;
    private int k;
    private int n;

    private int maxSumAfterPartitioningHandler(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int currentMax = Integer.MIN_VALUE;
        int result = 0;

        for (int j = i; j < Math.min(i + k, n); ++j) {
            currentMax = Math.max(currentMax, nums[j]);
            result = Math.max(result, (j - i + 1) * currentMax + maxSumAfterPartitioningHandler(j + 1));
        }

        return dp[i] = result;
    }

    public int maxSumAfterPartitioning(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        n = nums.length;
        dp = new int[n];

        Arrays.fill(dp, -1);

        return maxSumAfterPartitioningHandler(0);
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
          int k = sc.nextInt();

          System.out.println(new Solution().maxSumAfterPartitioning(nums, k));
      }
      
      sc.close(); 
  }
}
