import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int[][] grid;
    private int x;

    private int transform(int val) {
        int result = 0;

        for (int[] row : grid) {
            for (int num : row) {
                if (Math.abs(val - num) % x != 0) {
                    return Integer.MAX_VALUE;
                } else {
                    result += Math.abs(val - num) / x;
                }
            }
        }

        return result;
    }

    public int minOperations(int[][] grid, int x) {
        List<Integer> flattenedNums = new ArrayList<>();
        this.grid = grid;
        this.x = x;

        for (int[] row : grid) {
            for (int num : row) {
                flattenedNums.add(num);
            }
        }

        Collections.sort(flattenedNums);

        int size = flattenedNums.size();
        int answer = Math.min(transform(flattenedNums.get(size / 2)), transform(flattenedNums
                .get((size - 1) / 2)));

        return answer == Integer.MAX_VALUE ? -1 : answer;
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
           int x = scanner.nextInt();

           System.out.println(new Solution().minOperations(grid, x));
       }
       
       scanner.close();
   }
}
