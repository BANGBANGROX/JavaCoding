import java.util.Scanner;

class Solution {
    private boolean[][] visited;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int componentSize;

    private void dfs(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ++componentSize;
        visited[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 1) {
                dfs(newX, newY, grid);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    componentSize = 0;
                    dfs(i, j, grid);
                    maxArea = Math.max(maxArea, componentSize);
                }
            }
        }

        return maxArea;
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
            System.out.println(solution.maxAreaOfIsland(grid));
        }

        sc.close();
    }
}
