import java.util.Scanner;

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = Integer.MIN_VALUE, currSum = 0, maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            currSum = Math.max(0, currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            maxElement = Math.max(maxElement, nums[i]);
        }

        return maxSum == 0 ? maxElement : maxSum;
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
        System.out.println(obj.maxSubArray(nums));

        sc.close();
    }
}
