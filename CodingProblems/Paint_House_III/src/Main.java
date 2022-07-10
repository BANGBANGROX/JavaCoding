import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
         final int INF = (int)1e9;
         int ans = INF;
         int[][] dp = new int[target + 1][n];

         for (int i = 0; i <= target; ++i) {
             Arrays.fill(dp[i], INF);
         }

         if (houses[0] == 0) dp[1] = cost[0];
         else dp[1][houses[0] - 1] = 0;

         for (int i = 1; i < m; ++i) {
             for (int groups = target; groups > 0; --groups) {
                 for (int color1 = 0; color1 < n; ++color1) {
                     int minCost = dp[groups][color1];
                     dp[groups][color1] = INF;
                     if (houses[i] != 0 && houses[i] != color1 + 1) continue;
                     int currentCost = (houses[i] == 0) ? cost[i][color1] : 0;
                     minCost += currentCost;
                     for (int color2 = 0; color2 < n; ++color2) {
                         if (color1 == color2) continue;
                         minCost = Math.min(minCost, dp[groups - 1][color2] + currentCost);
                     }
                     dp[groups][color1] = minCost;
                 }
             }
         }

         for (int i = 0; i < n; ++i) {
             ans = Math.min(ans, dp[target][i]);
         }

         return ans == INF ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int[] houses = new int[m];
            for (int i = 0; i < m;++i) {
                houses[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[][] cost = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    cost[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minCost(houses, cost, m, n, target));
        }

        sc.close();
    }
}
