import java.util.Scanner;

class Solution {
    private int[][][][] dp;
    private String s;

    private int calculateLength(int num) {
        if (num == 0) return 0;

        if (num == 1) return 1;

        if (num < 10) return 2;

        if (num < 100) return 3;

        return 4;
    }

    private int dfs(int index, int k, char previousChar, int currentCnt) {
        if (index == s.length()) return calculateLength(currentCnt);

        if (previousChar != '#' && dp[index][k][previousChar - 'a'][currentCnt] != -1)
            return dp[index][k][previousChar - 'a'][currentCnt];

        int ans = Integer.MAX_VALUE;

        if (k > 0) ans = dfs(index + 1, k - 1, previousChar, currentCnt);

        if (s.charAt(index) == previousChar) {
            ans = Math.min(ans, dfs(index + 1, k, previousChar, currentCnt + 1));
        }
        else {
            ans = Math.min(ans, calculateLength(currentCnt) + dfs(index + 1, k, s.charAt(index), 1));
        }

        return previousChar == '#' ? ans : (dp[index][k][previousChar - 'a'][currentCnt] = ans);
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        int n = s.length();
        dp = new int[n][k + 1][26][101];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= k; ++j) {
                for (int l = 0; l < 26; ++l) {
                    for (int m = 0; m < 101; ++m) {
                        dp[i][j][l][m] = -1;
                    }
                }
            }
        }

        return dfs(0, k, '#', 0);
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
