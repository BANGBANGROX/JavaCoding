import java.util.Scanner;

class Solution {
    public int countOrders(int n) {
        long[][] dp = new long[n + 1][n + 1];
        int mod = (int) 1e9 + 7;

        for (int i = 0; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] += (i > 0) ? i * dp[i - 1][j] : 0;
                dp[i][j] %= mod;
                dp[i][j] += (j > i) ? (j - i) * dp[i][j - 1] : 0;
                dp[i][j] %= mod;
            }
        }

        return (int)dp[n][n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countOrders(n));
        }

        sc.close();
    }
}
