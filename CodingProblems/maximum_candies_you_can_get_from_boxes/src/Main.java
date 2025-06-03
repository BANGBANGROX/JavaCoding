import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys,
                          int[][] containedBoxes, int[] initialBoxes) {
        final Queue<Integer> queue = new LinkedList<>();
        final Set<Integer> discoveredBoxes = new HashSet<>();
        final int n = candies.length;
        final boolean[] visited = new boolean[n];
        int answer = 0;

        for (final int box : initialBoxes) {
            discoveredBoxes.add(box);
            if (status[box] == 1) {
                queue.add(box);
                visited[box] = true;
            }
        }

        while (!queue.isEmpty()) {
            final int box = queue.poll();
            answer += candies[box];
            for (final int key : keys[box]) {
                status[key] = 1;
                if (!visited[key] && discoveredBoxes.contains(key)) {
                    visited[key] = true;
                    queue.add(key);
                }

            }
            for (final int newBox : containedBoxes[box]) {
                discoveredBoxes.add(newBox);
                if (!visited[newBox] && status[newBox] == 1) {
                    visited[newBox] = true;
                    queue.add(newBox);
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] status = new int[n];
           for (int i = 0; i < n; ++i) {
               status[i] = scanner.nextInt();
           }
           final int[] candies = new int[n];
           for (int i = 0; i < n; ++i) {
               candies[i] = scanner.nextInt();
           }
           final int[][] keys = new int[n][];
           for (int i = 0; i < n; ++i) {
               final int m = scanner.nextInt();
               keys[i] = new int[m];
               for (int j = 0; j < m; ++j) {
                   keys[i][j] = scanner.nextInt();
               }
           }
           final int[][] containedBoxes = new int[n][];
           for (int i = 0; i < n; ++i) {
               final int m = scanner.nextInt();
               containedBoxes[i] = new int[m];
               for (int j = 0; j < m; ++j) {
                   containedBoxes[i][j] = scanner.nextInt();
               }
           }
           final int initialBoxesCount = scanner.nextInt();
           final int[] initialBoxes = new int[initialBoxesCount];
           for (int i = 0; i < initialBoxesCount; ++i) {
               initialBoxes[i] = scanner.nextInt();
           }

           System.out.println(new Solution().maxCandies(status, candies, keys, containedBoxes, initialBoxes));
       }
       
       scanner.close();
   }
}
