import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int row1 = m - 1;
        int row2 = m - 1;
        int col1 = 0;
        int col2 = 0;

        while (row2 > 0) {
            ArrayList<Integer> auxNums = new ArrayList<>();
            int i = row1;
            int j = col1;
            while (i <= row2 && j <= col2) {
                auxNums.add(mat[i][j]);
                ++i;
                ++j;
            }
            Collections.sort(auxNums);
            int idx = 0;
            i = row1;
            j = col1;
            while (i <= row2 && j <= col2) {
                mat[i][j] = auxNums.get(idx);
                ++i;
                ++j;
                ++idx;
            }
            if (row1 == 0) ++col1;
            else --row1;
            if (col2 == n - 1) --row2;
            else ++col2;
        }

        return mat;
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

            Solution solution = new Solution();
            int[][] ans = solution.diagonalSort(mat);
            for (int[] x: ans) {
                for (int y: x) System.out.print(y + " ");
                System.out.println();
            }
        }

        sc.close();
    }
}
