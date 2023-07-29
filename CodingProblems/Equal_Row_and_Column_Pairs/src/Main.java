import java.util.Scanner;

class Solution {
    public int equalPairs(int[][] grid) {
         int n = grid.length;
         int answer = 0;

        for (int[] ints : grid) {
            for (int col = 0; col < n; ++col) {
                boolean flag = true;
                for (int ind = 0; ind < n; ++ind) {
                    if (ints[ind] != grid[ind][col]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ++answer;
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
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.equalPairs(grid));
        }

        sc.close();
    }
}
