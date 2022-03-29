import java.util.Scanner;

class Solution {
    private int m;
    private int n;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private boolean allCovered = true;

    private void dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid2[x][y] == 0) return;

        if (grid2[x][y] == 1 && grid1[x][y] == 0) {
            allCovered = false;
            return;
        }

        grid2[x][y] = 0;

        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(grid1, grid2, newX, newY);
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
         m = grid2.length;
         n = grid2[0].length;
         int ans = 0;

         for (int i = 0; i < m; ++i) {
             for (int j = 0; j < n; ++j) {
                 if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                     dfs(grid1, grid2, i, j);
                     if (allCovered) ++ans;
                     allCovered = true;
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
            int[][] grid1 = new int[m][n];
            int[][] grid2 = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid1[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid2[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.countSubIslands(grid1, grid2));
        }

        sc.close();
    }
}
