import java.util.Scanner;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // First Col
        for (int i = m - 1; i >= 0; --i) {
            int row = i;
            int col = 0;
            int first = matrix[row][col];
            while (row < m && col < n) {
                if (matrix[row][col] != first) return false;
                ++row;
                ++col;
            }
        }

        // Firs row
        for (int i = 1; i < n; ++i) {
            int row = 0;
            int col = i;
            int first = matrix[row][col];
            while (row < m && col < n) {
                if (matrix[row][col] != first) return false;
                ++row;
                ++col;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.isToeplitzMatrix(matrix));
        }

        sc.close();
    }
}
