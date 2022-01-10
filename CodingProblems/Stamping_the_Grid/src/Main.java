import java.util.Scanner;

class Solution {
    private int[][] pref;

    private boolean isPossible(int x1, int y1, int x2, int y2) {
        return (pref[x2][y2] - (x1 > 0 ? pref[x1 - 1][y2] : 0) - (y1 > 0 ? pref[x2][y1 - 1] : 0)
                + (x1 > 0 && y1 > 0 ? pref[x1 - 1][y1 - 1] : 0)) == 0;
    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] marked = new int[m][n];
        boolean[][] ans = new boolean[m][n];
        pref = new int[m][n];

          for (int i = 0; i < m; ++i) {
              for (int j = 0; j < n; ++j) {
                  pref[i][j] = grid[i][j];
                  if (i == 0 && j == 0) continue;
                  else if (i == 0) pref[i][j] += pref[i][j - 1];
                  else if (j == 0) pref[i][j] += pref[i - 1][j];
                  else pref[i][j] += (pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1]);
              }
          }

          for (int i = 0; i < m; ++i) {
              for (int j = 0; j < n; ++j) {
                  if (grid[i][j] == 0 && i + stampHeight <= m && j + stampWidth <= n &&
                          isPossible(i, j, i + stampHeight - 1, j + stampWidth - 1)) {
                      ++marked[i][j];
                      if (j + stampWidth < n) --marked[i][j + stampWidth];
                  }
              }
          }

          for (int i = 0; i < m; ++i) {
              for (int j = 1; j < n; ++j) {
                  marked[i][j] += marked[i][j - 1];
              }
          }

          for (int i = 0; i < m; ++i) {
              for (int j = 0; j < n; ++j) {
                  if (grid[i][j] == 0 && marked[i][j] != 0) {
                      ans[i][j] = true;
                  }
              }
          }

          for (int j = 0; j < n; ++j) {
              for (int i = 0; i < m; ++i) {
                  if (grid[i][j] == 1 || marked[i][j] == 0) continue;
                  int k = i;
                  while (k < m && marked[k][j] != 0) ++k;
                  int down = stampHeight;
                  --k;
                  while (down > 0) {
                      ans[k][j] = true;
                      ++k;
                      --down;
                  }
                  i = k - 1;
              }
          }

          for (int i = 0; i < m; ++i) {
              for (int j = 0; j < n; ++j) {
                  if (grid[i][j] == 0 && !ans[i][j]) return false;
              }
          }

          return true;
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
            int stampHeight = sc.nextInt();
            int stampWidth = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.possibleToStamp(grid, stampHeight, stampWidth));
        }

        sc.close();
    }
}
