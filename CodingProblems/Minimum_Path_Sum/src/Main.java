import java.util.Scanner;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) continue;
                else if (i == m - 1) grid[i][j] += grid[i][j + 1];
                else if (j == n - 1) grid[i][j] += grid[i + 1][j];
                else grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        return grid[0][0];
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
            System.out.println(solution.minPathSum(grid));
        }

        sc.close();
    }
}
