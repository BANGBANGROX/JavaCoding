import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        List<Integer> interestingRows = new ArrayList<>();
        List<Integer> interestingCols = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            int cnt = 0;
            for (int val : grid[i]) {
                if (val == 1) {
                    ++cnt;
                }
            }
            if (cnt > 1) {
                answer += cnt;
                interestingRows.add(i);
            }
        }

        for (int j = 0; j < n; ++j) {
            int cnt = 0;
            for (int[] currentRow : grid) {
                if (currentRow[j] == 1) {
                    ++cnt;
                }
            }
            if (cnt > 1) {
                answer += cnt;
                interestingCols.add(j);
            }
        }

        for (int row : interestingRows) {
            for (int col : interestingCols) {
                if (grid[row][col] == 1) {
                    --answer;
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

           System.out.println(new Solution().countServers(grid));
       }
       
       scanner.close();
   }
}
