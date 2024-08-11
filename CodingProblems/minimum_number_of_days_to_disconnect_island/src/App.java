import java.util.Scanner;

class Solution {
    private boolean[][] visited;
    private int[][] grid;
    private int m;
    private int n;

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            dfs(newX, newY);
        }
    }

    private int computeIslandCount() {
        visited = new boolean[m][n];
        int islandCnt = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ++islandCnt;
                    dfs(i, j);
                }
            }
        }

        return islandCnt;
    }

    public int minDays(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        if (computeIslandCount() != 1) return 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (this.grid[i][j] == 1) {
                    this.grid[i][j] = 0;
                    if (computeIslandCount() != 1) {
                        return 1;
                    }
                    this.grid[i][j] = 1;
                }
            }
        }

        return 2;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            System.out.println(new Solution().minDays(grid));
        }

        scanner.close();
    }
}
