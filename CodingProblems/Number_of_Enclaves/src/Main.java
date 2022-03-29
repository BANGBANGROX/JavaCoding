import java.util.Scanner;

class Solution {
    private int m;
    private int n;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private void change(int[][] grid, int x, int y) {
       if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return;

       grid[x][y] = 0;

       for (int i = 0; i < 4; ++i) {
           int newX = x + dx[i];
           int newY = y + dy[i];
           change(grid, newX, newY);
       }
    }

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                    change(grid, i, j);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += grid[i][j];
            }
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
            System.out.println(solution.numEnclaves(grid));
        }

        sc.close();
    }
}
