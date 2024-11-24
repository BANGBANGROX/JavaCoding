import java.util.Scanner;

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long answer = 0;
        int nonPositiveElements = 0;
        int minValue = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val <= 0) {
                    ++nonPositiveElements;
                }
                answer += Math.abs(val);
                minValue = Math.min(minValue, Math.abs(val));
            }
        }

        if ((nonPositiveElements & 1) > 0) {
            answer -= 2L * minValue;
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
           int[][] matrix = new int[n][n];
           for (int i = 0; i < n; ++i) {
               for (int j = 0; j < n; ++j) {
                   matrix[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().maxMatrixSum(matrix));
       }
       
       scanner.close();
   }
}
