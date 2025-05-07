import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private record Cell(int x, int y, int distance) {
        @Override
        public boolean equals(final Object object) {
            if (!(object instanceof Cell(int x1, int y1, int distance1))) {
                return false;
            }

            return x1 == x && y1 == y && distance1 == distance;
        }
    }

    public int minTimeToReach(final int[][] moveTime) {
        final int m = moveTime.length;
        final int n = moveTime[0].length;
        final PriorityQueue<Cell> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        final int[][] distance = new int[m][n];
        final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (final int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        priorityQueue.add(new Cell(0, 0, distance[0][0]));

        while (!priorityQueue.isEmpty()) {
            final Cell cell = priorityQueue.poll();
            final int x = cell.x;
            final int y = cell.y;
            final int currentDistance = cell.distance;
            for (final int[] dir : directions) {
                final int newX = x + dir[0];
                final int newY = y + dir[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                final int newDistance = Math.max(currentDistance, moveTime[newX][newY]) + 1;
                if (newDistance < distance[newX][newY]) {
                    priorityQueue.remove(new Cell(newX, newY, distance[newX][newY]));
                    distance[newX][newY] = newDistance;
                    priorityQueue.add(new Cell(newX, newY, distance[newX][newY]));
                }
            }
        }

        return distance[m - 1][n - 1];
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int m = scanner.nextInt();
           final int n = scanner.nextInt();
           final int[][] moveTime = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   moveTime[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().minTimeToReach(moveTime));
       }
       
       scanner.close();
   }
}
