import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int maxDistance(int[][] grid) {
       int n = grid.length;
       int[][] distance = new int[n][n]; // distance[i][j] is the distance of (i,j) from the nearest 1.
       int[] dx = {1, 0, -1, 0};
       int[] dy = {0, 1, 0, -1};
       int ans = 0;
       Queue<Pair> q = new LinkedList<>();

       for (int i = 0; i < n; ++i) {
           for (int j = 0; j < n; ++j) {
               if (grid[i][j] == 1) {
                   q.add(new Pair(i, j));
               }
               else distance[i][j] = Integer.MAX_VALUE;
           }
       }

       while (!q.isEmpty()) {
           int x = q.peek().first;
           int y = q.peek().second;
           q.poll();
           ans = Math.max(ans, distance[x][y]);
           for (int i = 0; i < 4; ++i) {
               int newX = x + dx[i];
               int newY = y + dy[i];
               if (newX >= 0 && newX < n && newY >= 0 && newY < n && distance[newX][newY] > 1 + distance[x][y]) {
                   distance[newX][newY] = 1 + distance[x][y];
                   q.add(new Pair(newX, newY));
               }
           }
       }

       return ans == 0 ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
