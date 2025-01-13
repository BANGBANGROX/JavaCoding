import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] coins;
    private int[][][] dp;
    private int m;
    private int n;

    private int maximumAmountHandler(int row, int col,
                                      int neutralizeTimes) {
        if (row == m - 1 && col == n - 1) {
            if (coins[row][col] >= 0) return coins[row][col];
            if (neutralizeTimes > 0) return 0;
            return coins[row][col];
        }

        if (dp[row][col][neutralizeTimes] != Integer.MIN_VALUE)
            return dp[row][col][neutralizeTimes];

        int result = Integer.MIN_VALUE;

        if (coins[row][col] >= 0) {
            if (row + 1 < m) {
                result = Math.max(result,
                        maximumAmountHandler(row + 1, col, neutralizeTimes));
            }
            if (col + 1 < n) {
                result = Math.max(result,
                        maximumAmountHandler(row, col + 1, neutralizeTimes));
            }
            result += coins[row][col];
        } else {
            int nonNeutralizeResult = Integer.MIN_VALUE;
            int neutralizeResult = Integer.MIN_VALUE;

            if (row + 1 < m) {
                nonNeutralizeResult = Math.max(nonNeutralizeResult,
                        maximumAmountHandler(row + 1, col, neutralizeTimes));
                if (neutralizeTimes > 0) {
                    neutralizeResult = Math.max(neutralizeResult, maximumAmountHandler(row + 1, col, neutralizeTimes - 1));
                }
            }
            if (col + 1 < n) {
                nonNeutralizeResult = Math.max(nonNeutralizeResult,
                        maximumAmountHandler(row, col + 1, neutralizeTimes));
                if (neutralizeTimes > 0) {
                    neutralizeResult = Math.max(neutralizeResult, maximumAmountHandler(row , col + 1, neutralizeTimes - 1));
                }
            }
            nonNeutralizeResult += coins[row][col];
            result = Math.max(neutralizeResult, nonNeutralizeResult);
        }

        return dp[row][col][neutralizeTimes] = result;
    }

    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        m = coins.length;
        n = coins[0].length;
        dp = new int[m][n][3];

        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, Integer.MIN_VALUE);
            }
        }

        return maximumAmountHandler(0, 0, 2);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int[][] coins = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   coins[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().maximumAmount(coins));
       }
       
       scanner.close();
   }
}
