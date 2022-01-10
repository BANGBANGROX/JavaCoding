import java.util.Scanner;

class Solution {
    public String longestPalindrome(String s) {
          int n = s.length();
          int maxLen = 1;
          int start = -1;
          int end = -1;
          boolean[][] dp = new boolean[n][n];

          for (int len = 1; len <= n; ++len) {
              for (int i = 0; i <= n - len; ++i) {
                  int j = len + i - 1;
                  char a = s.charAt(i);
                  char b = s.charAt(j);
                  if (len == 1) {
                      dp[i][j] = true;
                      if (maxLen < len) {
                          maxLen = len;
                          start = i;
                          end = j;
                      }
                      continue;
                  }
                  if (len == 2) {
                      dp[i][j] = a == b;
                      if (dp[i][j] && maxLen < len) {
                          maxLen = len;
                          start = i;
                          end = j;
                      }
                      continue;
                  }
                  if (a == b) {
                      dp[i][j] = dp[i + 1][j - 1];
                  }
                  if (dp[i][j] && maxLen < len) {
                      maxLen = len;
                      start = i;
                      end = j;
                  }
              }
          }

          return s.substring(start, end + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
