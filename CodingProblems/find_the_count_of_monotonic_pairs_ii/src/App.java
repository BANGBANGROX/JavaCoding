import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int answer = 0;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] dp = new int[maxValue + 1];
        final int MOD = (int) 1e9 + 7;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            int initialValue = Math.max(nums[i] - nums[i - 1], 0);
            int[] dp2 = new int[maxValue + 1];
            for (int val = initialValue; val <= nums[i]; ++val) {
                dp2[val] = ((val > 0 ? dp2[val - 1] : 0) + dp[val - initialValue]) % MOD;
            }
            dp = dp2;
        }

        for (int i = 0; i <= nums[n - 1]; ++i) {
            answer = (answer + dp[i]) % MOD;
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }

            System.out.println(new Solution().countOfPairs(nums));
        }

        scanner.close();
    }
}
