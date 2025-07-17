import java.util.Scanner;

class Solution {
    public int maximumLength(final int[] nums, final int k) {
        final int[][] dp = new int[k][k];
        int answer = 0;

        for (final int num : nums) {
            for (int mod = 0; mod < k; ++mod) {
                dp[num % k][mod] = dp[mod][num % k] + 1;
                answer = Math.max(answer, dp[num % k][mod]);
            }
        }

        return answer;
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

           System.out.println(new Solution().maximumLength(nums, k));
       }
       
       scanner.close();
   }
}
