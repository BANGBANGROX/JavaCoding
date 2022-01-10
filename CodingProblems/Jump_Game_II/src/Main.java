import java.util.Scanner;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        int maxReach = nums[0], steps = nums[0], jumps = 1;

        for (int i = 1; i < n; ++i) {
            if (i == n - 1) return jumps;
            maxReach = Math.max(maxReach, i + nums[i]);
            --steps;
            if (steps == 0) {
                ++jumps;
                steps = maxReach - i;
            }
        }

        return -1;
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
        System.out.println(obj.jump(nums));

        sc.close();
    }
}
