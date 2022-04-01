import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private int n;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};
    private Queue<Pair> q;

    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void change(int x, int y, int[][] grid) {
          q.add(new Pair(x, y));
          grid[x][y] = 2;

          for (int i = 0; i < 4; ++i) {
              int newX = x + dx[i];
              int newY = y + dy[i];
              if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                  change(newX, newY, grid);
              }
          }
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        int[][] distance = new int[n][n];

        for (int i = 0; i < n; ++i) {
            boolean islandFound = false;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    change(i, j, grid);
                    islandFound = true;
                    break;
                }
            }
            if (islandFound) break;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 2) distance[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            if (grid[x][y] == 1) ans = Math.min(ans, distance[x][y] - 1);
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && distance[newX][newY] > distance[x][y] + 1) {
                    distance[newX][newY] = 1 + distance[x][y];
                    q.add(new Pair(newX, newY));
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
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.print(solution.shortestBridge(grid));
        }

        sc.close();
    }
}
