import java.util.Scanner;

class Solution {
    private int twoCitySchedCost(int idx, int[][] costs, int sentToA, int[][] dp) {
        int n = costs.length;
        int sentToB = idx - sentToA;

        if (idx == n) return 0;

        if (dp[idx][sentToA] != -1) return dp[idx][sentToA];

        int ans = Integer.MAX_VALUE;

        // Let's try and send idx to A
        if (sentToA < n / 2) ans = twoCitySchedCost(idx + 1, costs, sentToA + 1, dp) + costs[idx][0];

        // Now let's try and send idx to B
        if (sentToB < n / 2) ans = Math.min(ans,
                twoCitySchedCost(idx + 1, costs, sentToA, dp) + costs[idx][1]);

        return dp[idx][sentToA] = ans;
    }

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = -1;
            }
        }

        return twoCitySchedCost(0, costs, 0, dp);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] costs = new int[n][3];
            for (int i = 0; i < n; ++i) {
                costs[i][0] = sc.nextInt();
                costs[i][1] = sc.nextInt();
                costs[i][2] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.twoCitySchedCost(costs));
        }

        sc.close();
    }
}
