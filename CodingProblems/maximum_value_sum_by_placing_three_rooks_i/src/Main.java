import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private long[][][] dp;
    private int[][] board;
    private int m;
    private int n;

    private long maximumValueSumHandler(int row, int firstRookPosition, int secondRookPosition) {
        if (row >= m) {
            long INF = (long) 1e16;
            return -1 * INF;
        }

        if (dp[row][firstRookPosition + 1][secondRookPosition + 1] != -1) {
            return dp[row][firstRookPosition + 1][secondRookPosition + 1];
        }

        long result = maximumValueSumHandler(row + 1, firstRookPosition, secondRookPosition);

        for (int col = 0; col < n; ++col) {
            if (col != firstRookPosition && col != secondRookPosition) {
                if (firstRookPosition == -1) {
                    result = Math.max(result, board[row][col] + maximumValueSumHandler(row + 1, col, secondRookPosition));
                }
                else if (secondRookPosition == -1) {
                    result = Math.max(result, board[row][col] + maximumValueSumHandler(row + 1, firstRookPosition, col));
                } else {
                    result = Math.max(result, board[row][col]);
                }
            }
        }

        return dp[row][firstRookPosition + 1][secondRookPosition + 1] = result;
    }

    public long maximumValueSum(int[][] board) {
        m = board.length;
        n = board[0].length;
        dp = new long[m][n + 1][n + 1];
        this.board = board;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j <= n; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maximumValueSumHandler(0, -1, -1);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int[][] board = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   board[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().maximumValueSum(board));
       }
   }
}
