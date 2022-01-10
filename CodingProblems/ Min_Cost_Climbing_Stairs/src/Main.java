import java.util.Scanner;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[n - 1] = cost[n - 1];

        for (int i = n - 2; i > -1; --i) {
            if (i + 2 >= n) {
                dp[i] = cost[i];
                continue;
            }
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; ++i) {
                cost[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            System.out.println(obj.minCostClimbingStairs(cost));
        }

        sc.close();
    }
}
