import java.util.Scanner;

class Solution {
    public String findTheString(int[][] lcp) {
         int n = lcp.length;
         char[] result = new char[n];

         result[0] = 'a';

         for (int i = 1; i < n; ++i) {
             char test = 'a';
             boolean found = false;
             for (int j = 0; j < i; ++j) {
                 test = (char) Math.max(test, result[j]);
                 if (lcp[i][j] > 0) {
                     result[i] = result[j];
                     found = true;
                     break;
                 }
             }
             if (found) continue;
             ++test;
             if (test > 'z') return "";
             result[i] = test;
         }

         int[][] dp = new int[n + 1][n + 1];
         int val;

         for (int i = n - 1; i >= 0; --i) {
             for (int j = n - 1; j >= 0; --j) {
                 if (result[i] != result[j]) {
                     val = 0;
                 }
                 else {
                     val = dp[i + 1][j + 1] + 1;
                 }
                 dp[i][j] = val;
             }
         }

         for (int i = 0; i < n; ++i) {
             for (int j = 0; j < n; ++j) {
                 if (dp[i][j] != lcp[i][j]) return "";
             }
         }

         return new String(result);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] lcp = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    lcp[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.findTheString(lcp));
        }

        sc.close();
    }
}
