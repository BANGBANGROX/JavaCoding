import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums[nums.length - 1] + 2];

        for (int firstValue : nums) {
            int secondValue = firstValue + 1;
            dp[secondValue] = Math.max(dp[secondValue], dp[secondValue - 1] + 1);
            dp[firstValue] = Math.max(dp[firstValue], dp[firstValue - 1] + 1);
        }

        return Arrays.stream(dp).max().getAsInt();
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
            System.out.println(solution.maxSelectedElements(nums));
        }

        sc.close();
    }
}
