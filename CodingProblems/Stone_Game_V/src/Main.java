import java.util.Scanner;

class Solution {
    private int[][] dp;

    private int maxScore(int start, int end, int[] stoneValue) {
        if (start == end) return 0;

        if (dp[start][end] != -1) return dp[start][end];

        int left = 0;
        int right = 0;
        int ans = 0;

        for (int i = start; i <= end; ++i) {
            right += stoneValue[i];
        }

        for (int i = start; i < end; ++i) {
            // Partition at index i
            left += stoneValue[i];
            right -= stoneValue[i];

            if (left < right) {
                // Discard right side
                ans = Math.max(ans, left + maxScore(start, i, stoneValue));
            }

            else if (left == right) {
                // Choose the better one
                int leftResult = left + maxScore(start, i, stoneValue);
                int rightResult = right + maxScore(i + 1, end, stoneValue);
                ans = Math.max(ans, Math.max(leftResult, rightResult));
            }

            else {
                // Discard left side
                ans = Math.max(ans, right + maxScore(i + 1, end, stoneValue));
            }
        }

        return dp[start][end] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = -1;
            }
        }

        return maxScore(0, n - 1, stoneValue);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] stoneValues = new int[n];
            for (int i = 0; i < n; ++i) {
                stoneValues[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.stoneGameV(stoneValues));
        }

        sc.close();
    }
}
