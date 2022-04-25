import java.util.Scanner;

class Solution {
    private boolean check(int[][] mat, int len, int threshold) {
         int m = mat.length;
         int n = mat[0].length;

         for (int i = 0; i + len <= m; ++i) {
             for (int j = 0; j + len <= n; ++j) {
                 int lastRow = i + len - 1;
                 int lastCol = j + len - 1;
                 int sum = (mat[lastRow][lastCol] - (i > 0 ? mat[i - 1][lastCol] : 0) -
                         (j > 0 ? mat[lastRow][j - 1] : 0) +
                         (i > 0 && j > 0 ? mat[i - 1][j - 1] : 0));
                 if (sum <= threshold) return true;
             }
         }

         return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int l = 1;
        int r = Math.min(m, n);
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) continue;
                if (i == 0) mat[i][j] += mat[i][j - 1];
                else if (j == 0) mat[i][j] += mat[i - 1][j];
                else mat[i][j] += (mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1]);
            }
        }

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(mat, mid, threshold)) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return ans;
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
            int threshold = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maxSideLength(mat, threshold));
        }

        sc.close();
    }
}
