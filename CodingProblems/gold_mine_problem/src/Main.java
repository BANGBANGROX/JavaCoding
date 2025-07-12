import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] mat;
    private int[][] dp;
    private int n;

    public int maxGold(final int[][] mat) {
        // code here
        final int m = mat.length;
        n = mat[0].length;
        dp = new int[m][n];
        this.mat = mat;
        int answer = 0;

        for (final int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; ++i) {
            answer = Math.max(answer, maxGoldHandler(i, 0));
        }

        return answer;
    }

    private int maxGoldHandler(final int i, final int j) {
        if (j == n - 1) {
            return mat[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int result = mat[i][j] + maxGoldHandler(i, j + 1);

        if (i > 0) {
            result = Math.max(result, mat[i][j] + maxGoldHandler(i - 1, j + 1));
        }

        if (i + 1 < n) {
            result = Math.max(result, mat[i][j] + maxGoldHandler(i + 1, j + 1));
        }

        return dp[i][j] = result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int m = scanner.nextInt();
           final int n = scanner.nextInt();
           final int[][] mat = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   mat[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().maxGold(mat));
       }
       
       scanner.close();
   }
}
