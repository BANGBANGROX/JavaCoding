import java.util.Scanner;

class Solution {
    public int longestPalindromeSubseq(String s) {
         int n = s.length();
         int maxLen = 1;
         int[][] dp = new int[n][n];

         for (int i = n - 1; i >= 0; --i) {
             for (int j = i; j < n; ++j) {
                 char a = s.charAt(i);
                 char b = s.charAt(j);
                 if (i == j) {
                     dp[i][j] = 1;
                     continue;
                 }
                 if ((j - i + 1) == 2) {
                     if (a == b) dp[i][j] = 2;
                     else dp[i][j] = 1;
                     maxLen = Math.max(maxLen, dp[i][j]);
                     continue;
                 }
                 if (a == b) {
                     dp[i][j] = dp[i + 1][j - 1] + 2;
                     maxLen = Math.max(maxLen, dp[i][j]);
                 }
                 else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
             }
         }

         return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.longestPalindromeSubseq(s));
        }

        sc.close();
    }
}
