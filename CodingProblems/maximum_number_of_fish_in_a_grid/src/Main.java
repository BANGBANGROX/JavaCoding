import java.util.Scanner;

class Solution {
    private int[][] grid;
    private int currentScore;
    private int m;
    private int n;

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        currentScore += grid[x][y];
        grid[x][y] = 0;

        for (int[] direction : directions) {
            dfs(x + direction[0], y + direction[1]);
        }
    }

    public int findMaxFish(int[][] grid) {
        int answer = 0;
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    currentScore = 0;
                    dfs(i, j);
                    answer = Math.max(answer, currentScore);
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

           System.out.println(new Solution().findMaxFish(grid));
       }
       
       scanner.close();
   }
}
