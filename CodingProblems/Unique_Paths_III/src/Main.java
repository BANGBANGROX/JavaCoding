import java.util.Scanner;

class Solution {
    private final int[] dx = {-1, 0, 0, 1};
    private final int[] dy = {0, 1, -1, 0};
    private int m;
    private int n;

    private int dfs(int x, int y, int steps, int[][] grid) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1) return 0;

        if (grid[x][y] == 2) return steps == -1 ? 1 : 0;

        int ans = 0;

        grid[x][y] = -1;

        for (int i = 0; i < 4; ++i) {
            ans += dfs(x + dx[i], y + dy[i], steps - 1, grid);
        }

        return ans;
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int sx = -1;
        int sy = -1;
        int steps = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                else if (grid[i][j] == 0) ++steps;
            }
        }

        return dfs(sx, sy, steps, grid);
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
            System.out.println(solution.uniquePathsIII(grid));
        }

        sc.close();
    }
}
