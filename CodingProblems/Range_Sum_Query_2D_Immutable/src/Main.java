import javax.xml.transform.SourceLocator;
import java.util.Arrays;
import java.util.Scanner;

class NumMatrix {
    int m, n;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) matrix[i][j] += matrix[i][j - 1];
                else if (j == 0) matrix[i][j] += matrix[i - 1][j];
                else matrix[i][j] += (matrix[i - 1][j] + matrix[i][j - 1] + matrix[i - 1][j - 1]);
            }
        }

        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2] - (row1 > 0 ? matrix[row1 - 1][col2] : 0) - (col1 > 0 ? matrix[row2][col1 - 1] : 0)
                + (row1 > 0 && col1 > 0 ? matrix[row1 - 1][col1 - 1] : 0);
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

            NumMatrix numMatrix = new NumMatrix(matrix);
            numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e. sum of the red rectangle)
            numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e. sum of the green rectangle)
            numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e. sum of the blue rectangle)
        }

        sc.close();
    }
}
