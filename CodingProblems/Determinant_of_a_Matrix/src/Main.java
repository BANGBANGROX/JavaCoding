//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution {
    //Function for finding determinant of matrix.
    public int determinantOfMatrix(int[][] matrix, int n) {
        // code here
        if (n == 1) {
            return matrix[0][0];
        }

        int answer = 0;

        for (int col = 0; col < n; ++col) {
            // Remove colth col and 0th row
            int[][] nextMatrix = new int[n - 1][n - 1];
            int rowIndex = 0;
            for (int i = 1; i < n; ++i) {
                int colIndex = 0;
                for (int j = 0; j < n; ++j) {
                    if (j != col) {
                        nextMatrix[rowIndex][colIndex] = matrix[i][j];
                        ++colIndex;
                    }
                }
                ++rowIndex;
            }
            int val = matrix[0][col] * determinantOfMatrix(nextMatrix, n - 1);
            answer += (col % 2 == 0 ? val : -1 * val);
        }

        return answer;
    }
}

