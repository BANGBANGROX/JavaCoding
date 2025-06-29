import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private int n;
    private int[][] dp;

    public int minXor(final int[] nums, final int k) {
        n = nums.length;
        dp = new int[n][k + 1];
        this.nums = nums;

        for (final int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minXorHandler(0, k);
    }

    private int minXorHandler(final int idx, int remainingParts) {
        if (idx == n && remainingParts == 0) {
            return 0;
        }

        if (idx == n || remainingParts == 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[idx][remainingParts] != -1) {
            return dp[idx][remainingParts];
        }

        int result = Integer.MAX_VALUE;
        int current = 0;

        for (int i = idx; i < n - remainingParts + 1; ++i) {
            current ^= nums[i];
            int next = minXorHandler(i + 1, remainingParts - 1);
            int maxValue = Math.max(current, next);
            result = Math.min(result, maxValue);
        }

        return dp[idx][remainingParts] = result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().minXor(nums, k));
       }
       
       scanner.close();
   }
}
