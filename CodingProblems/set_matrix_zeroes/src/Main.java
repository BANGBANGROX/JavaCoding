//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int i = 0; i < n; ++i) {
            if (mat[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; ++i) {
            if (mat[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int i = 0; i < n; ++i) {
                mat[0][i] = 0;
            }
        }

        if (isFirstColZero) {
            for (int i = 0; i < m; ++i) {
                mat[i][0] = 0;
            }
        }
    }
}