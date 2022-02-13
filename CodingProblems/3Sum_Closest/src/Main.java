import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            int currentSum = (target - nums[i]);
            int l = i + 1;
            int r = n - 1;
            int currentResult = Integer.MAX_VALUE;
            while (l < r) {
                int difference = currentSum - nums[l] - nums[r];
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(difference) < currentResult) {
                    currentResult = Math.abs(difference);
                    if (ans == Integer.MAX_VALUE || Math.abs(target - ans) > Math.abs(target - sum)) {
                        ans = sum;
                    }
                }
                if (difference > 0) ++l;
                else --r;
            }
        }

        return ans;
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
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.threeSumClosest(nums, target));
        }

        sc.close();
    }
}
