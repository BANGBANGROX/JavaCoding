import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int[] nums;
    private int n;
    private final int MOD = (int) 1e9 + 7;

    private int countOfPairsHandler(int idx, int lastArr1, int lastArr2) {
        if (idx >= n)
            return 1;

        if (dp[idx][lastArr1][lastArr2] != -1)
            return dp[idx][lastArr1][lastArr2];

        int result = 0;

        for (int nextNum1 = lastArr1; nextNum1 <= nums[idx]; ++nextNum1) {
            int nextNum2 = nums[idx] - nextNum1;
            if (nextNum2 <= lastArr2) {
                result = (result + countOfPairsHandler(idx + 1, nextNum1, nextNum2)) % MOD;
            }
        }

        return dp[idx][lastArr1][lastArr2] = result;
    }

    public int countOfPairs(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        dp = new int[n][maxValue + 1][maxValue + 1];
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= maxValue; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int firstNum = 0; firstNum <= nums[0]; ++firstNum) {
            answer = (answer + countOfPairsHandler(1, firstNum, nums[0] - firstNum)) % MOD;
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
