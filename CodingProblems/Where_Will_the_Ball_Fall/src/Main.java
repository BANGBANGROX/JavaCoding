import java.util.Scanner;

class Solution {
    public int[] findBall(int[][] grid) {
         int n = grid[0].length;
         int[] ans = new int[n];

         for (int ball = 0; ball < n; ++ball) {
             int currentPos = ball;
             for (int[] ints : grid) {
                 int nextPos = currentPos + ints[currentPos];
                 if (nextPos < 0 || nextPos >= n || ints[nextPos] != ints[currentPos]) {
                     currentPos = -1;
                     break;
                 }
                 currentPos = nextPos;
             }
             ans[ball] = currentPos;
         }

         return ans;
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
            int[] ans = solution.findBall(grid);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
