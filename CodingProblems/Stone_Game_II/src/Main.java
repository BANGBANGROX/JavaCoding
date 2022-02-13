import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int n;

    private int maxScore(int[] piles, int index, int m) {
        if (index == n) return 0;

        if (dp[index][m] != -1) return dp[index][m];

        int ans = Integer.MIN_VALUE;
        int total = 0;

        for (int i = 0; i < 2 * m; ++i) {
            if (index + i >= n) break;
            total += piles[index + i];
            ans = Math.max(ans, total - maxScore(piles, index + i + 1, Math.max(m, i + 1)));
        }

        return dp[index][m] = ans;
    }

    public int stoneGameII(int[] piles) {
        this.n = piles.length;
        dp = new int[n][n];

        if (n == 1) return piles[0];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = -1;
            }
        }

        int sum = Arrays.stream(piles).sum();
        int difference = maxScore(piles, 0, 1);

        return (sum + difference) / 2;
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

            Solution solution = new Solution();
            System.out.println(solution.stoneGameII(piles));
        }

        sc.close();
    }
}
