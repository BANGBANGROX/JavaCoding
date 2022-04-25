import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int findSum(int[] nums, int value) {
       int sum = 0;

       for (int num : nums) {
           sum += Math.min(num, value);
       }

       return sum;
    }

    public int findBestValue(int[] nums, int target) {
        int l = 0;
        int r = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        int minDifference = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int sum = findSum(nums, mid);
            int difference = Math.abs(sum - target);
            if (difference < minDifference) {
                ans = mid;
                minDifference = difference;
            }
            else if (difference == minDifference) {
                ans = Math.min(ans, mid);
            }
            if (sum > target) r = mid - 1;
            else l = mid + 1;
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
            System.out.println(solution.findBestValue(nums, target));
        }

        sc.close();
    }
}
