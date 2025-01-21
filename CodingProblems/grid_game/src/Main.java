import java.util.Scanner;

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] firstRowSuffixSum = new long[n];
        long[] secondRowPrefixSum = new long[n];
        long answer = Long.MAX_VALUE;

        firstRowSuffixSum[n - 1] = grid[0][n - 1];
        secondRowPrefixSum[0] = grid[1][0];

        for (int i = n - 2; i >= 0; --i) {
            firstRowSuffixSum[i] = firstRowSuffixSum[i + 1] + grid[0][i];
        }

        for (int i = 1; i < n; ++i) {
            secondRowPrefixSum[i] = secondRowPrefixSum[i - 1] + grid[1][i];
        }

        for (int turnIndex = 0; turnIndex < n; ++turnIndex) {
            long result = 0;
            if (turnIndex - 1 >= 0) {
                result = Math.max(result, secondRowPrefixSum[turnIndex - 1]);
            }
            if (turnIndex + 1 < n) {
                result = Math.max(result, firstRowSuffixSum[turnIndex + 1]);
            }
            answer = Math.min(answer, result);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[][] grid = new int[2][n];
           for (int i = 0; i < 2; ++i) {
               for (int j = 0; j < n; ++j) {
                   grid[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().gridGame(grid));
       }
       
       scanner.close();
   }
}
