import java.util.Scanner;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
          int n = nums.length;
          int seqNum = 1;
          int total = 0;
          int[] dp = new int[n];

          for (int i = 0; i < n; ++i) dp[i] = (int)1e5;

          for (int i = 1; i < n - 1; ++i) {
              if (2 * nums[i] == (nums[i - 1] + nums[i + 1])) {
                  int d = nums[i] - nums[i - 1];
                  if (dp[i - 1] == d) ++seqNum;
                  else seqNum = 1;
                  total += seqNum;
                  dp[i] = d;
              }
          }

          return total;
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
            System.out.println(obj.numberOfArithmeticSlices(nums));
        }

        sc.close();
    }
}
