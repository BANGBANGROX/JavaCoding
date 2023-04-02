import java.util.*;

class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            assert cell != null;
            int x = cell[0];
            int y = cell[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            int t = cell[2];
            if (x == m - 1 && y == n - 1) return t;
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int waitTime = (grid[newX][newY] - t) % 2 == 0 ? 1 : 0;
                    pq.add(new int[]{newX, newY,
                            Math.max(grid[newX][newY] + waitTime, t + 1)});
                }
            }
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

            Solution solution = new Solution();
            System.out.println(solution.minimumTime(grid));
        }

        sc.close();
    }
}
