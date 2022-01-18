import java.util.Scanner;

class Solution {
    private int len;
    private int[] ones, zeroes;
    private int[][][] dp;

    private int countOnes(String s) {
        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') ++res;
        }

        return res;
    }

    private int findMaxForm(int index, int currentOnes, int currentZeroes) {
        if (index >= len) return 0;

        if (dp[index][currentOnes][currentZeroes] != -1) return dp[index][currentOnes][currentZeroes];

        int ans;

        // Leave the current string
        ans = findMaxForm(index + 1, currentOnes, currentZeroes);

        // If possible take the current string
        if (currentOnes - ones[index] >= 0 && currentZeroes - zeroes[index] >= 0) {
            ans = Math.max(ans, findMaxForm(index + 1, currentOnes - ones[index],
                    currentZeroes - zeroes[index]) + 1);
        }

        return dp[index][currentOnes][currentZeroes] = ans;
    }

    public int findMaxForm(String[] str, int m, int n) {
        len = str.length;
        ones = new int[len];
        zeroes = new int[len];
        dp = new int[len][n + 1][m + 1];

        for (int i = 0; i < len; ++i) {
            ones[i] = countOnes(str[i]);
            zeroes[i] = str[i].length() - ones[i];
        }

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= m; ++k) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return findMaxForm(0, n, m);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int len = sc.nextInt();
            String[] str = new String[len];
            for (int i = 0; i < len; ++i) {
                str[i] = sc.next();
            }
            int m = sc.nextInt();
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.findMaxForm(str, m, n));
        }

        sc.close();
    }
}
