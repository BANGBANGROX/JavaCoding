import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] grid;
    private int[][] dp;

    private int maxMovesHandler(int x, int y) {
        if (y == grid[0].length - 1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        int result = 0;

        if (x > 0 && grid[x - 1][y + 1] > grid[x][y]) {
            result = Math.max(result, maxMovesHandler(x - 1, y + 1));
        }

        if (grid[x][y + 1] > grid[x][y]) {
            result = Math.max(result, maxMovesHandler(x, y + 1));
        }

        if (x < grid.length - 1 && grid[x + 1][y + 1] > grid[x][y]) {
            result = Math.max(result, maxMovesHandler(x + 1, y + 1));
        }

        return dp[x][y] = result + 1;
    }

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        dp = new int[grid.length][grid[0].length];
        int answer = 0;

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < grid.length; ++i) {
            answer = Math.max(answer, maxMovesHandler(i, 0) - 1);
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

           System.out.println(new Solution().maxMoves(grid));
       }
       
       scanner.close();
   }
}
