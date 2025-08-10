import java.util.Scanner;

class Solution {
    public int countPS(final String s) {
        // code here
        final int n = s.length();
        final boolean[][] dp = new boolean[n][n];
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                final int j = i + len - 1;

                if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] |= dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countPS(scanner.next()));
       }
       
       scanner.close();
   }
}
