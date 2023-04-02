import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[] satisfaction;
    private int n;

    private int maxSatisfactionUtil(int index, int timeElapsed) {
        if (index >= n) return 0;

        if (dp[index][timeElapsed] != Integer.MIN_VALUE) return dp[index][timeElapsed];

        int leave = maxSatisfactionUtil(index + 1, timeElapsed);
        int taken = maxSatisfactionUtil(index + 1, timeElapsed + 1) +
                satisfaction[index] * timeElapsed;

        return dp[index][timeElapsed] = Math.max(taken, leave);
    }

    public int maxSatisfaction(int[] satisfaction) {
        this.satisfaction = satisfaction;
        n = satisfaction.length;
        dp = new int[n][n + 1];

        Arrays.sort(this.satisfaction);

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return maxSatisfactionUtil(0, 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] satisfaction = new int[n];
            for (int i = 0; i < n; ++i) {
                satisfaction[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxSatisfaction(satisfaction));
        }

        sc.close();
    }
}
