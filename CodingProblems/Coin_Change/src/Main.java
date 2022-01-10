import java.util.Scanner;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; ++i) dp[i] = Integer.MAX_VALUE;

        for (int coin : coins) {
            for (int amt = 1; amt <= amount; ++amt) {
                if (coin > amt || dp[amt - coin] == Integer.MAX_VALUE) continue;
                dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; ++i) coins[i] = sc.nextInt();
            int amount = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.coinChange(coins, amount));
        }

        sc.close();
    }
}
