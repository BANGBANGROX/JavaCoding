import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        Set<Integer> answer = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        for (int i = 0; i < m; ++i) {
            rowMin[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
            }
        }

        for (int j = 0; j < n; ++j) {
            colMax[j] = Integer.MIN_VALUE;
            for (int i = 0; i < m; ++i) {
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rowMin[i] == matrix[i][j] && colMax[j] == matrix[i][j]) {
                    answer.add(matrix[i][j]);
                }
            }
        }

        return new ArrayList<>(answer);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
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

            System.out.println(new Solution().luckyNumbers(matrix));
        }

        scanner.close();
    }
}
