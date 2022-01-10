import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Cell {
    public int height, x, y;
    public Cell(int height, int x, int y) {
        this.height = height;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int ans = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int maxHeight = 0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    vis[i][j] = true;
                    pq.add(new Cell(heightMap[i][j], i, j));
                }
            }
        }

        while (!pq.isEmpty()) {
            int currHeight = pq.peek().height;
            int x = pq.peek().x;
            int y = pq.peek().y;
            pq.poll();
            maxHeight = Math.max(currHeight, maxHeight);
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !vis[newX][newY]) {
                    pq.add(new Cell(heightMap[newX][newY], newX, newY));
                    vis[newX][newY] = true;
                    if (heightMap[newX][newY] < maxHeight) ans += (maxHeight - heightMap[newX][newY]);
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
            int[][] heightMap = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    heightMap[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            System.out.println(obj.trapRainWater(heightMap));
        }

        sc.close();
    }
}
