import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(List::getFirst));

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(List.of(0, 0, 0));
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            List<Integer> current = pq.poll();
            assert current != null;
            int currentDistance = current.get(0);
            int x = current.get(1);
            int y = current.get(2);
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newDistance = currentDistance + grid[newX][newY];
                    if (distance[newX][newY] > newDistance) {
                        if (newX == m - 1 && newY == n - 1) return newDistance;
                        distance[newX][newY] = newDistance;
                        pq.add(List.of(distance[newX][newY], newX, newY));
                    }
                }
            }
        }

        return distance[m - 1][n - 1];
    }
}

public class Main {
   public static void main(String[] args) {
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

           System.out.println(new Solution().minimumObstacles(grid));
       }
       
       scanner.close();
   }
}
