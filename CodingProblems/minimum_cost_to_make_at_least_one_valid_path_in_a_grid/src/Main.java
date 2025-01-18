import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    private List<List<int[]>> graph;
    private int m;
    private int n;

    private int singleSourceShortestPath() {
        int[] distance = new int[m * n];
        TreeSet<List<Integer>> treeSet = new TreeSet<>((a, b) ->
                !Objects.equals(a.get(1), b.get(1)) ? a.get(1) - b.get(1) :
                        a.getFirst() - b.getFirst());

        Arrays.fill(distance, Integer.MAX_VALUE);

        treeSet.add(List.of(0, 0));
        distance[0] = 0;

        while (!treeSet.isEmpty()) {
            List<Integer> cellData = treeSet.pollFirst();
            assert cellData != null;
            int idx = cellData.getFirst();
            int currentDistance = cellData.get(1);
            if (currentDistance > distance[idx]) {
                continue;
            }
            for (int[] childCellData : graph.get(idx)) {
                int childIdx = childCellData[0];
                int weight = childCellData[1];
                if (currentDistance + weight < distance[childIdx]) {
                    treeSet.remove(List.of(childIdx, distance[childIdx]));
                    distance[childIdx] = currentDistance + weight;
                    treeSet.add(List.of(childIdx, distance[childIdx]));
                }
            }
        }

        return distance[m * n - 1];
    }

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        graph = new ArrayList<>();
        int[][] directions = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                graph.add(new ArrayList<>());
                int idx = i * n + j;
                for (int k = 1; k <= 4; ++k) {
                    int newX = i + directions[k][0];
                    int newY = j + directions[k][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        int newIdx = newX * n + newY;
                        if (k == grid[i][j]) {
                            graph.get(idx).add(new int[]{newIdx, 0});
                        } else {
                            graph.get(idx).add(new int[]{newIdx, 1});
                        }
                    }
                }
            }
        }

        return singleSourceShortestPath();
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

           System.out.println(new Solution().minCost(grid));
       }
       
       scanner.close();
   }
}
