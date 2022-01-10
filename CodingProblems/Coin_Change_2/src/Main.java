import java.util.Scanner;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; ++i) {
            for (int amt = 0; amt <= amount; ++amt) {
                if (amt == 0) {
                    dp[i][amt] = 1;
                    continue;
                }
                if (i == 0) continue;
                dp[i][amt] += dp[i - 1][amt];
                if (coins[i - 1] <= amt) dp[i][amt] += dp[i][amt - coins[i - 1]];
            }
        }

        return dp[n][amount];
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
            System.out.println(solution.change(amount, coins));
        }

        sc.close();
    }
}
