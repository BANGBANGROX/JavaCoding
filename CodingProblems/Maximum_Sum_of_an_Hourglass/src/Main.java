import java.util.Scanner;

class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int firstRow = 0;
        int lastRow = 2;

        while (lastRow < m) {
            int firstCol = 0;
            int lastCol = 2;
            while (lastCol < n) {
                int currentSum = 0;
                for (int i = firstCol; i <= lastCol; ++i) {
                    currentSum += grid[firstRow][i];
                    currentSum += grid[lastRow][i];
                }
                currentSum += grid[firstRow + 1][firstCol + 1];
                ans = Math.max(ans, currentSum);
                ++firstCol;
                ++lastCol;
            }
            ++firstRow;
            ++lastRow;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.maxSum(grid));
        }

        sc.close();
    }
}
