import java.util.Scanner;

class Solution {
    public int countPalindromicSubsequences(String s) {
        final int MOD = (int) 1e9 + 7;
        int n = s.length();
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high && s.charAt(i) != s.charAt(low)) {
                        ++low;
                    }
                    while (low <= high && s.charAt(j) != s.charAt(high)) {
                        --high;
                    }
                    if (low > high) {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 2) % MOD;
                    } else if (low == high) {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 1) % MOD;
                    } else {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1] + MOD) % MOD;
                    }
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + MOD) % MOD;
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            System.out.println(new Solution().countPalindromicSubsequences(scanner.next()));
        }

        scanner.close();
    }
}
