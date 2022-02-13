import java.util.Scanner;

class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 2; i <= n; ++i) {
            if (dp[i]) continue;
            for (int j = 1; i + j * j <= n; ++j) {
                dp[i + j * j] = true;
            }
        }

        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.winnerSquareGame(n));
        }

        sc.close();
    }
}
