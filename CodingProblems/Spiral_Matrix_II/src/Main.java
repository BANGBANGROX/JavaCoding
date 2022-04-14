import java.util.Scanner;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int value = 1;
        int firstRow = 0;
        int lastRow = n - 1;
        int firstCol = 0;
        int lastCol = n - 1;

        while (firstRow <= lastRow) {
            // Fill the first row
            for (int i = firstCol; i <= lastCol; ++i) {
                ans[firstRow][i] = value;
                ++value;
            }
            ++firstRow;
            // Fill the last col
            for (int i = firstRow; i <= lastRow; ++i) {
                ans[i][lastCol] = value;
                ++value;
            }
            --lastCol;
            // Fill the last row
            for (int i = lastCol; i >= firstCol; --i) {
                ans[lastRow][i] = value;
                ++value;
            }
            --lastRow;
            // Fill the first col
            for (int i = lastRow; i >= firstRow; --i) {
                ans[i][firstCol] = value;
                ++value;
            }
            ++firstCol;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            int[][] ans = solution.generateMatrix(n);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
