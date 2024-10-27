import java.util.Scanner;

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 0;

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j],
                            Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
                }
            }
        }

        for (int[] row : matrix) {
            for (int val : row) {
                answer += val;
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
           int[][] matrix = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   matrix[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().countSquares(matrix));
       }
       
       scanner.close();
   }
}
