import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int COLS;
    private int[][] dp;
    private int[][] colWiseCost;

    private int minimumOperationsHandler(int i, int excludingDigit) {
        if (i >= COLS) return 0;

        if (excludingDigit == -1) {
            int result = Integer.MAX_VALUE;

            for (int dig = 0; dig < 10; ++dig) {
                result = Math.min(result, colWiseCost[0][dig] + minimumOperationsHandler(i + 1, dig));
            }

            return result;
        }

        if (dp[i][excludingDigit] != -1) return dp[i][excludingDigit];

        int result = Integer.MAX_VALUE;

        for (int dig = 0; dig < 10; ++dig) {
            if (dig != excludingDigit) {
                result = Math.min(result, colWiseCost[i][dig] + minimumOperationsHandler(i + 1, dig));
            }
        }

        return dp[i][excludingDigit] = result;
    }

    public int minimumOperations(int[][] grid) {
        COLS = grid[0].length;
        dp = new int[COLS][10];
        colWiseCost = new int[COLS][10];

        for (int dig = 0; dig < 10; ++dig) {
            for (int col = 0; col < COLS; ++col) {
                int cost = 0;
                for (int[] ints : grid) {
                    if (ints[col] != dig) {
                        ++cost;
                    }
                }
                colWiseCost[col][dig] = cost;
            }
        }

        for (int i = 0; i < COLS; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return minimumOperationsHandler(0, -1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            final int ROWS = sc.nextInt();
            final int COLS = sc.nextInt();
            int[][] grid = new int[ROWS][COLS];
            for (int i = 0; i < ROWS; ++i) {
                for (int j = 0; j < COLS; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.minimumOperations(grid));
        }

        sc.close();
    }
}
