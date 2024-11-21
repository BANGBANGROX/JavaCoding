import java.util.Scanner;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards,
                              int[][] walls) {
        int[][] grid = new int[m][n];
        int coverage = 0;

        for (int[] wallCell : walls) {
            grid[wallCell[0]][wallCell[1]] = 1;
        }

        for (int[] guardCell : guards) {
            grid[guardCell[0]][guardCell[1]] = 1;
        }

        for (int[] guardCell : guards) {
            int x = guardCell[0] - 1;
            int y = guardCell[1];
            while (x >= 0 && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    ++coverage;
                    grid[x][y] = -1;
                }
                --x;
            }
            x = guardCell[0] + 1;
            while (x < m && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    ++coverage;
                    grid[x][y] = -1;
                }
                ++x;
            }
            x = guardCell[0];
            y = guardCell[1] - 1;
            while (y >= 0 && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    ++coverage;
                    grid[x][y] = -1;
                }
                --y;
            }
            y = guardCell[1] + 1;
            while (y < n && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    ++coverage;
                    grid[x][y] = -1;
                }
                ++y;
            }
        }

        return m * n - guards.length - walls.length - coverage;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int guardsCnt = scanner.nextInt();
           int[][] guards = new int[guardsCnt][2];
           for (int i = 0; i < guardsCnt; ++i) {
               guards[i][0] = scanner.nextInt();
               guards[i][1] = scanner.nextInt();
           }
           int wallsCnt = scanner.nextInt();
           int[][] walls = new int[wallsCnt][2];
           for (int i = 0; i < wallsCnt; ++i) {
               walls[i][0] = scanner.nextInt();
               walls[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().countUnguarded(m, n, guards, walls));
       }
       
       scanner.close();
   }
}
