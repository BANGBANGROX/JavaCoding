import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
         int n = nums.length;

         if (n == 1) return true;

         int maxReach = nums[0], steps = nums[0];

         if (maxReach == 0) return false;

         for (int i = 1; i < n; ++i) {
             if (i == n - 1) return true;
             maxReach = Math.max(maxReach, i + nums[i]);
             --steps;
             if (steps == 0) {
                 if (i >= maxReach) return false;
                 steps = maxReach - i;
             }
         }

         return false;
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
        System.out.println(obj.canJump(nums));

        sc.close();
    }
}
