import java.util.Scanner;

class Solution {
    private int[] dp;
    private int n;

    private int maxScore(int[] piles, int index) {
        if (index == n) return 0;

        if (dp[index] != Integer.MIN_VALUE) return dp[index];

        int ans;

        ans = piles[index] - maxScore(piles, index + 1);

        if (index + 1 < n) {
            ans = Math.max(piles[index] + piles[index + 1] - maxScore(piles, index + 2), ans);
        }

        if (index + 2 < n) {
            ans = Math.max(piles[index] + piles[index + 1] + piles[index + 2] -
                    maxScore(piles, index + 3), ans);
        }

        return dp[index] = ans;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = Integer.MIN_VALUE;
        }

        int difference = maxScore(stoneValue, 0);

        if (difference > 0) return "Alice";

        if (difference == 0) return "Tie";

        return "Bob";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] piles = new int[n];
            for (int i = 0; i < n; ++i) {
                piles[i] = sc.nextInt();
            }

            System.out.println(new Solution().stoneGameIII(piles));
        }

        sc.close();
    }
}
