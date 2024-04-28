import java.util.Scanner;

class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        final int ROWS = grid.length;
        final int COLS = grid[0].length;
        int[] rowSum = new int[ROWS];
        int[] colSum = new int[COLS];
        long answer = 0;

        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                rowSum[i] += grid[i][j];
            }
        }

        for (int i = 0; i < COLS; ++i) {
            for (int j = 0; j < ROWS; ++j) {
                colSum[i] += grid[j][i];
            }
        }

        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (grid[i][j] == 1) {
                    long rowCount = rowSum[i] - grid[i][j];
                    long colCount = colSum[i] - grid[i][j];
                    answer += rowCount * colCount;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            final int ROWS = sc.nextInt();
            final int COLS = sc.nextInt();
            final int[][] grid = new int[ROWS][COLS];
            for (int i = 0; i < ROWS; ++i) {
                for (int j = 0; j < COLS; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            System.out.println(new Solution().numberOfRightTriangles(grid));
        }

        sc.close();
    }
}
