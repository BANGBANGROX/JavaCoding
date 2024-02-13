import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int calculateLength(int num) {
        return num > 1 ? num > 9 ? num > 99 ? num > 999 ? 4 : 3 : 2 : 1 : 0;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], 9999);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                int cnt = 0;
                int del = 0;
                for (int l = i; l >= 1; --l) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) {
                        ++cnt;
                    }
                    else {
                        ++del;
                    }
                    if (del <= j) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 +
                                calculateLength(cnt));
                    }
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][k];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.getLengthOfOptimalCompression(s, k));
        }

        sc.close();
    }
}
