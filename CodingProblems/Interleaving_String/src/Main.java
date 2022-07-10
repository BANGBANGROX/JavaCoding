import java.util.Scanner;

class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
             int m = s1.length();
             int n = s2.length();
             int o = s3.length();

             if (o != m + n) return false;

             boolean[][] dp = new boolean[m + 1][n + 1];

             for (int i = 0; i <= m; ++i) {
                     for (int j = 0; j <= n; ++j) {
                          if (i == 0 && j == 0) dp[i][j] = true;
                          else if (i == 0) {
                                  dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                          }
                          else if (j == 0) {
                                  dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                          }
                          else {
                                  dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                                          (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                          }
                     }
             }

             return dp[m][n];
        }
}

public class Main {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();

          while (T-->0) {
              String s1 = sc.next();
              String s2 = sc.next();
              String s3 = sc.next();

              Solution solution = new Solution();
              System.out.println(solution.isInterleave(s1, s2, s3));
          }

        sc.close();
     }
}
