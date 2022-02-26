import java.util.Scanner;

class Solution {
    public boolean isMatch(String s, String p) {
      int m = s.length();
      int n = p.length();
      boolean[][] dp = new boolean[m + 1][n + 1];

      dp[0][0] = true;

      for (int i = 0; i < n; ++i) {
          if (p.charAt(i) == '*') dp[0][i + 1] = true;
          else break;
      }

      for (int i = 0; i < m; ++i) {
          for (int j = 0; j < n; ++j) {
              if (p.charAt(j) == '*') {
                  dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
              }
              else dp[i + 1][j + 1] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i][j];
          }
      }

      return dp[m][n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            String p = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.isMatch(s, p));
        }

        sc.close();
    }
}
