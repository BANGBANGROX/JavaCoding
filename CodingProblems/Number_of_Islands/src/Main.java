import java.util.Scanner;

class Solution {
    private boolean[][] visited;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private void dfs(int x, int y, char[][] grid) {
        visited[x][y] = true;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(newX, newY, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
         int ans = 0;
         int m = grid.length;
         int n = grid[0].length;
         visited = new boolean[m][n];

         for (int i = 0; i < m; ++i) {
             for (int j = 0; j < n; ++j) {
                 if (!visited[i][j] && grid[i][j] == '1') {
                     ++ans;
                     dfs(i, j, grid);
                 }
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
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.next().charAt(0);
                }
            }

            Solution solution = new Solution();
            System.out.print(solution.numIslands(grid));
        }

        sc.close();
    }
}
