import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public int countPaths(int[][] grid) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        final int MOD = (int) 1e9 + 7;
        int[][] dp = new int[m][n];
        int[][] cellList = new int[m * n][2];
        int answer = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cellIndex = i * n + j;
                cellList[cellIndex][0] = i;
                cellList[cellIndex][1] = j;
            }
        }

        Arrays.sort(cellList, Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, 1));

        for (int[] cell : cellList) {
            int x = cell[0];
            int y = cell[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] >
                        grid[x][y]) {
                    dp[newX][newY] = (dp[newX][newY] + dp[x][y]) % MOD;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = (answer + dp[i][j]) % MOD;
            }
        }

        return answer;
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
            System.out.println(solution.countPaths(grid));
        }

        sc.close();
    }
}
