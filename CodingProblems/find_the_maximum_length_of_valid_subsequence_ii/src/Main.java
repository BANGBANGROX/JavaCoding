import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k]; // dp[i][j] is the max length of the subsequence with last element as nums[i] % k with remainder j
        int answer = 1;

        for (int num : nums) {
            for (int mod = 0; mod < k; ++mod) {
                dp[num % k][mod] = dp[mod][num % k] + 1;
                answer = Math.max(answer, dp[num % k][mod]);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            System.out.println(new Solution().maximumLength(nums, k));
        }

        scanner.close();
    }
}
