import java.util.Scanner;

class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];

        for (int i = 1; i < n; ++i) {
            stones[i] += stones[i - 1];
        }

        dp[n - 2] = stones[n - 1];

        for (int i = n - 3; i >= 0; --i) {
            dp[i] = Math.max(dp[i + 1], stones[i + 1] - dp[i + 1]);
        }

        return dp[0];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] stones = new int[n];
            for (int i = 0; i < n; ++i) {
                stones[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.stoneGameVIII(stones));
        }

        sc.close();
    }
}
