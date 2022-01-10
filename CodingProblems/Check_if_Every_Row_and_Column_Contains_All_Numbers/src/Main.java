import java.util.Scanner;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; ++i) {
            boolean[] isThere = new boolean[n + 1];
            for (int j = 0; j < n; ++j) {
                if (!isThere[matrix[i][j]]) isThere[matrix[i][j]] = true;
                else return false;
            }
        }

        for (int j = 0; j < n; ++j) {
            boolean[] isThere = new boolean[n + 1];
            for (int i = 0; i < n; ++i) {
                if (!isThere[matrix[i][j]]) isThere[matrix[i][j]] = true;
                else return false;
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
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.checkValid(matrix));
        }

        sc.close();
    }
}
