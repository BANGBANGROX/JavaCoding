import java.util.*;

class Solution {
    private int[][] dp;
    private int n;
    private List<List<Integer>> piles;

    private int maxValueOfCoins(int idx, int k) {
        if (k == 0 || idx == n) return 0;

        if (dp[idx][k] != -1) return dp[idx][k];

        int ans = maxValueOfCoins(idx + 1, k);
        int currentSum = 0;

        for (int i = 0; i < Math.min(piles.get(idx).size(), k); ++i) {
            currentSum += piles.get(idx).get(i);
            ans = Math.max(ans, currentSum + maxValueOfCoins(idx + 1, k - i - 1));
        }

        return dp[idx][k] = ans;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        dp = new int[n][k + 1];
        this.piles = piles;

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return maxValueOfCoins(0, k);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<List<Integer>> piles = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                List<Integer> currentPile = new ArrayList<>();
                for (int j = 0; j < m; ++j) {
                    int x = sc.nextInt();
                    currentPile.add(x);
                }
                piles.add(new ArrayList<>(currentPile));
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.print(solution.maxValueOfCoins(piles, k));
        }

        sc.close();
    }
}
