import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] dp;
    private int[] nums;
    private int length;

    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    private int maxScoreHandler(int pairsPicked, int currentMask) {
        if (2 * pairsPicked == length) return 0;

        if (dp[currentMask] != -1) return dp[currentMask];

        int maximumScore = 0;

        for (int firstIndex = 0; firstIndex < length; ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex < length; ++secondIndex) {
                if ((currentMask & (1 << firstIndex)) > 0 || (currentMask & (1 << secondIndex)) > 0) {
                    continue;
                }
                int newMask = currentMask | (1 << firstIndex) | (1 << secondIndex);
                int currentScore = (pairsPicked + 1) * calculateGCD(nums[firstIndex], nums[secondIndex]);
                int remainingScore = maxScoreHandler(pairsPicked + 1, newMask);
                maximumScore = Math.max(maximumScore, currentScore + remainingScore);
            }
        }

        return dp[currentMask] = maximumScore;
    }

    public int maxScore(int[] nums) {
        this.nums = nums;
        length = nums.length;
        dp = new int[(1 << length) + 1];

        Arrays.fill(dp, -1);

        return maxScoreHandler(0, 0);
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
            System.out.println(solution.maxScore(nums));
        }

        sc.close();
    }
}
