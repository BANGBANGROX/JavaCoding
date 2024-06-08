import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] dp;
    private String s;
    private boolean[][] palindrome;

    private int minCutHandler(int i) {
        if (i >= s.length()) return 0;

        if (dp[i] != -1) return dp[i];

        int result = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); ++j) {
            if (palindrome[i][j]) {
                result = Math.min(result, 1 + minCutHandler(j + 1));
            }
        }

        return dp[i] = result;
    }

    private void computePalindromeSubstring() {
        palindrome = new boolean[s.length()][s.length()];

        for (int len = 1; len <= s.length(); ++len) {
            for (int i = 0; i + len <= s.length(); ++i) {
                int j = i + len - 1;
                if (len == 1) {
                    palindrome[i][j] = true;
                } else if (len == 2) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1];
                }
            }
        }
    }

    public int minCut(String s) {
        this.s = s;
        dp = new int[s.length()];

        computePalindromeSubstring();
        Arrays.fill(dp, -1);

        return minCutHandler(0) - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            System.out.println(new Solution().minCut(s));
        }

        sc.close();
    }
}
