import java.util.Scanner;

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        long minDiff = Long.MAX_VALUE;
        int ans = -1;

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for (int i = 0; i < n; ++i) {
            long leftSum;
            long rightSum;
            if (i == 0) {
                leftSum = nums[0];
                rightSum = suffix[0] - nums[0];
            } else if (i == n - 1) {
                leftSum = prefix[n - 1];
                rightSum = 0;
            } else {
                leftSum = prefix[i];
                rightSum = suffix[i + 1];
            }
            long leftAverage = leftSum / (i + 1);
            long rightAverage = i < n - 1 ? rightSum / (n - i - 1) : 0;
            long difference = Math.abs(leftAverage - rightAverage);
            if (difference < minDiff) {
                minDiff = difference;
                ans = i;
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

            Solution solution = new Solution();
            System.out.println(solution.minimumAverageDifference(nums));
        }

        sc.close();
    }
}
