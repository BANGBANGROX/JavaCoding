import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private String s;
    private int n;

    private int strangePrinterHandler(int left, int right) {
        if (dp[left][right] != -1) return dp[left][right];

        int j = -1;
        dp[left][right] = n;

        for (int i = left; i < right; ++i) {
            if (s.charAt(i) != s.charAt(right) && j == -1) {
                j = i;
            }
            if (j != -1) {
                dp[left][right] = Math.min(dp[left][right], strangePrinterHandler(j, i) +
                        strangePrinterHandler(i + 1, right) + 1);
            }
        }

        if (j == -1) dp[left][right] = 0;

        return dp[left][right];
    }

    public int strangePrinter(String s) {
         n = s.length();
         dp = new int[n][n];
         this.s = s;

         for (int i = 0; i < n; ++i) {
             Arrays.fill(dp[i], -1);
         }

         return strangePrinterHandler(0, n - 1) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.strangePrinter(s));
        }

        sc.close();
    }
}
