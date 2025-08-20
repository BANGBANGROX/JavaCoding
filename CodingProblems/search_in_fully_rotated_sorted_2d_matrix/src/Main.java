import java.util.Scanner;

class Solution {
    public boolean searchMatrix(final int[][] mat, final int x) {
        // code here
        for (final int[] row : mat) {
            for (final int val : row) {
                if (val == x) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            final int m = scanner.nextInt();
            final int n = scanner.nextInt();
            final int[][] mat = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            final int x = scanner.nextInt();

            System.out.println(new Solution().searchMatrix(mat, x));
        }

        scanner.close();
    }
}
