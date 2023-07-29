import java.util.Scanner;

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) dp[i][j] = 1;
                else if (s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i + 1][j - 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return n - dp[0][n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minInsertions(s));
        }

        sc.close();
    }
}
