import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int minValue = Arrays.stream(nums).min().getAsInt();
        int maxDifference = maxValue - minValue;
        int answer = 1;
        int[][] dp = new int[n][2 * maxDifference + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2 * maxDifference; ++j) {
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = nums[j] - nums[i] + maxDifference;
                dp[i][d] = dp[j][d] + 1;
                answer = Math.max(answer, dp[i][d]);
            }
        }

        return answer;
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
            System.out.println(solution.longestArithSeqLength(nums));
        }

        sc.close();
    }
}
