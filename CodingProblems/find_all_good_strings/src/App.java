import java.util.Scanner;

class Solution {
    private String s1;
    private String s2;
    private String evil;
    private int n;
    private int[][][][] dp;
    private int[] lps;

    private void computeLps() {
        int len = evil.length();
        lps = new int[len];
        int matchingLen = 0;
        int i = 1;

        while (i < len) {
            if (evil.charAt(i) == evil.charAt(matchingLen)) {
                ++matchingLen;
                lps[i] = matchingLen;
                ++i;
            } else {
                if (matchingLen > 0) {
                    matchingLen = lps[matchingLen - 1];
                } else {
                    ++i;
                }
            }
        }
    }

    private int findGoodStringsHandler(int idx, int evilMatched, boolean leftBoundCrossed, boolean rightBoundCrossed) {
        if (evilMatched == evil.length()) return 0;

        if (idx == n) return 1;

        if (dp[idx][evilMatched][leftBoundCrossed ? 1 : 0][rightBoundCrossed ? 1 : 0] != -1) {
            return dp[idx][evilMatched][leftBoundCrossed ? 1 : 0][rightBoundCrossed ? 1 : 0];
        }

        int result = 0;
        char leftBound = leftBoundCrossed ? s1.charAt(idx) : 'a';
        char rightBound = rightBoundCrossed ? s2.charAt(idx) : 'z';
        final int MOD = (int) 1e9 + 7;
        
        for (char ch = leftBound; ch <= rightBound; ++ch) {
            int j = evilMatched;
            while (j > 0 && evil.charAt(j) != ch) {
                j = lps[j - 1];
            }
            if (evil.charAt(j) == ch) ++j;
            result = (result + findGoodStringsHandler(idx + 1, j, leftBoundCrossed && (ch == leftBound), rightBoundCrossed && (ch == rightBound))) % MOD;
        }

        return dp[idx][evilMatched][leftBoundCrossed ? 1 : 0][rightBoundCrossed ? 1 : 0] = result;
    }

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        this.s1 = s1;
        this.s2 = s2;
        this.evil = evil;
        dp = new int[n][evil.length()][2][2];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < evil.length(); ++j) {
                for (int k = 0; k < 2; ++k) {
                    dp[i][j][k][0] = dp[i][j][k][1] = -1;
                }
            }
        }
        
        computeLps();

        return findGoodStringsHandler(0, 0, true, true);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            String evil = scanner.next();

            System.out.println(new Solution().findGoodStrings(n, s1, s2, evil));
        }

        scanner.close();
    }
}
