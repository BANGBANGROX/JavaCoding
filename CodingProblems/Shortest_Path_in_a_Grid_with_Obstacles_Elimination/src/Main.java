import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();

        if (m == 1 && n == 1) return 0;

        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] currentCell = q.poll();
                assert currentCell != null;
                int x = currentCell[0];
                int y = currentCell[1];
                int el = currentCell[2];
                for (int j = 0; j < 4; ++j) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    int newEl = el;
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                        if (newX == m - 1 && newY == n - 1) return ans + 1;
                        if (grid[newX][newY] == 1) --newEl;
                        if (newEl >= 0 && !visited[newX][newY][newEl]) {
                            visited[newX][newY][newEl] = true;
                            q.offer(new int[]{newX, newY, newEl});
                        }
                    }
                }
            }
            ++ans;
        }

        return -1;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.shortestPath(grid, k));
        }

        sc.close();
    }
}
