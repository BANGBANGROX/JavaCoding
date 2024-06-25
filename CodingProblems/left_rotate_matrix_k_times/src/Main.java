//{ Driver Code Starts
// Initial Template for java

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S1 = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int[][] ans = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    private void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        k %= n;

        System.arraycopy(nums, k, result, 0, n - k);
        System.arraycopy(nums, 0, result, n - k, k);
        System.arraycopy(result, 0, nums, 0, n);
    }

    public int[][] rotateMatrix(int k, int[][] mat) {
        // code here
        for (int[] row : mat) {
            rotateLeft(row, k);
        }

        return mat;
    }
}