import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int m;
    private int n;
    private int[][] dp;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[n + 1][1025];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return colorTheGridHandler(0, 0, 0, 0);
    }

    private int colorTheGridHandler(int previousState, int currentState, int row, int col) {
        if (col == n) {
            return 1;
        }

        if (row == m) {
            return colorTheGridHandler(currentState, 0, 0, col + 1);
        }

        if (row == 0 && dp[col][previousState] != -1) {
            return dp[col][previousState];
        }

        final int MOD = (int) 1e9 + 7;
        final int upperColor = currentState & 3;
        final int leftColor = (previousState >> ((m - row - 1) * 2)) & 3;
        int totalWays = 0;

        for (int color = 1; color <= 3; ++color) {
            if (color != upperColor && color != leftColor) {
                totalWays = (int) (((long) totalWays + colorTheGridHandler(previousState, (currentState << 2) + color, row + 1, col)) % MOD);
            }
        }

        if (row == 0) {
            dp[col][previousState] = totalWays;
        }

        return totalWays;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().colorTheGrid(scanner.nextInt(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
