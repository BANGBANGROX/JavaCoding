import java.util.Scanner;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int value1 = dp[i - 1][j];
                    int value2 = dp[i][j - 1];
                    int value3 = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(value1, Math.min(value2, value3)) + 1;
                }
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
            String word1 = sc.next();
            String word2 = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minDistance(word1, word2));
        }

        sc.close();
    }
}
