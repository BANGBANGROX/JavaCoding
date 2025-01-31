import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int[][] grid;
    private int m;
    private int n;
    private int currentIslandId;
    private Map<Integer, Integer> islandSizes;

    private int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) return 0;

        grid[x][y] = currentIslandId;

        return dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1) + 1;
    }

    private int computeSizeAfterConversion(int i, int j) {
        int currentSize = 1;
        Set<Integer> neighbours = new HashSet<>();

        if (i > 0 && grid[i - 1][j] > 1) {
            neighbours.add(grid[i - 1][j]);
        }
        if (j > 0 && grid[i][j - 1] > 1) {
            neighbours.add(grid[i][j - 1]);
        }
        if (i < m - 1 && grid[i + 1][j] > 1) {
            neighbours.add(grid[i + 1][j]);
        }
        if (j < n - 1 && grid[i][j + 1] > 1) {
            neighbours.add(grid[i][j + 1]);
        }

        for (int id : neighbours) {
            currentSize += islandSizes.get(id);
        }

        return currentSize;
    }

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        currentIslandId = 2;
        islandSizes = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    islandSizes.put(currentIslandId, dfs(i, j));
                    ++currentIslandId;
                }
            }
        }

        if (islandSizes.isEmpty()) return 1;

        if (islandSizes.size() == 1) {
            --currentIslandId;
            answer = islandSizes.get(currentIslandId);
            return answer == m * n ? answer : answer + 1;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    answer = Math.max(answer, computeSizeAfterConversion(i, j));
                }
            }
        }

        return answer;
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

           System.out.println(new Solution().largestIsland(grid));
       }
       
       scanner.close();
   }
}
