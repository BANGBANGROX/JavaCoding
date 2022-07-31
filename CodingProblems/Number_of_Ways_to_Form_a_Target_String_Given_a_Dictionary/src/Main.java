import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[][] lettersCount;
    private String target;

    private int numWaysUtil(int i, int j) {
        if (i >= target.length()) return 1;

        if (j >= lettersCount.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (lettersCount[j][target.charAt(i) - 'a'] > 0) {
            int MOD = (int) 1e9 + 7;
            long a = ((long)numWaysUtil(i + 1, j + 1) * lettersCount[j][target.charAt(i) - 'a']) % MOD;
            long b = numWaysUtil(i, j + 1);
            return dp[i][j] = (int)(a + b) % MOD;
        }

        return dp[i][j] = numWaysUtil(i, j + 1);
    }

    public int numWays(String[] words, String target) {
        dp = new int[target.length()][words[0].length()];
        lettersCount = new int[words[0].length()][26];
        this.target = target;

        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                ++lettersCount[i][word.charAt(i) - 'a'];
            }
        }

        for (int i = 0; i < target.length(); ++i) {
            Arrays.fill(dp[i], -1);
        }

        return numWaysUtil(0, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }
            String target = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.numWays(words, target));
        }

        sc.close();
    }
}
