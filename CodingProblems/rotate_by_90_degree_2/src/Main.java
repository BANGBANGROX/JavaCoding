//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    public void rotateby90(int[][] mat) {
        // code here
        int n = mat.length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                mat[i][j] += mat[j][i];
                mat[j][i] = mat[i][j] - mat[j][i];
                mat[i][j] = mat[i][j] - mat[j][i];
            }
        }

        for (int j = 0; j < n; ++j) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                mat[left][j] += mat[right][j];
                mat[right][j] = mat[left][j] - mat[right][j];
                mat[left][j] = mat[left][j] - mat[right][j];
                ++left;
                --right;
            }
        }
    }
}