import java.util.Scanner;

class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n];

       if (n == 1) return nums[0];

       dp[0] = nums[0];
       dp[1] = Math.max(dp[0], nums[1]);

       for (int i = 2; i < n; ++i) {
           dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
       }

       return dp[n - 1];
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
