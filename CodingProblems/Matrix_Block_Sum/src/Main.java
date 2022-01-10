import java.util.Scanner;

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) continue;
                if (i == 0) mat[i][j] += mat[i][j - 1];
                else if (j == 0) mat[i][j] += mat[i - 1][j];
                else mat[i][j] = mat[i][j] + mat[i][j - 1] + mat[i - 1][j] - mat[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int rowStart = i - k;
                int rowEnd = Math.min(m - 1, i + k);
                int colStart = j - k;
                int colEnd = Math.min(n - 1, j + k);
                answer[i][j] = mat[rowEnd][colEnd];
                if (rowStart > 0) answer[i][j] -= mat[rowStart - 1][colEnd];
                if (colStart > 0) answer[i][j] -= mat[rowEnd][colStart - 1];
                if (rowStart > 0 && colStart > 0) answer[i][j] += mat[rowStart - 1][colStart - 1];
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] mat = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = sc.nextInt();
                }
            }
            int k = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.matrixBlockSum(mat, k));
        }

        sc.close();
    }
}
