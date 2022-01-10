import java.util.Scanner;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
         int n = nums.length, currSum = nums[0], ans = nums[0], leftSum = 0;
         int[] suffix = new int[n];
         int[] maxRight = new int[n];

         suffix[n - 1] = nums[n - 1];

         for (int i = 1; i < n; ++i) {
             currSum = nums[i] + Math.max(currSum, 0);
             ans = Math.max(currSum, ans);
         }

         for (int i = n - 2; i >= 0; --i) {
             suffix[i] = suffix[i + 1] + nums[i];
         }

         maxRight[n - 1] = suffix[n - 1];

         for (int i = n - 2; i >= 0; --i) {
             maxRight[i] = Math.max(maxRight[i + 1], suffix[i]);
         }

         for (int i = 0; i < n - 2; ++i) {
             leftSum += nums[i];
             ans = Math.max(ans, leftSum + maxRight[i + 2]);
         }

         return ans;
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
        System.out.println(obj.maxSubarraySumCircular(nums));

        sc.close();
    }
}
