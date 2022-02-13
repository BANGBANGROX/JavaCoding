import java.util.Scanner;

class Solution {
    private int[][] dp;

    private int maxScore(int[] piles, int l, int r) {
        if (r - l == 1) {
            int difference = Math.max(piles[l], piles[r]) - Math.min(piles[l], piles[r]);
            return dp[l][r] = difference;
        }

        if (dp[l][r] != Integer.MIN_VALUE) return dp[l][r];

        int ans;

        // Take left corner
        ans = piles[l] - maxScore(piles, l + 1, r);

        // Take right corner
        ans = Math.max(ans, piles[r] - maxScore(piles, l, r - 1));

        return dp[l][r] = ans;
    }

    public boolean stoneGame(int[] piles) {
       int n = piles.length;
       dp = new int[n][n];

       for (int i = 0; i < n; ++i) {
           for (int j = 0; j < n; ++j) {
               dp[i][j] = Integer.MIN_VALUE;
           }
       }

       if (maxScore(piles, 0, n - 1) > 0) return true;

       return false;
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
            System.out.println(solution.stoneGame(piles));
        }

        sc.close();
    }
}
