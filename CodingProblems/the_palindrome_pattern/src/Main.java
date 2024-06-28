//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private boolean isPalindrome(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] != nums[right]) {
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }

    private int checkPalindrome(int[][] matrix) {
        int m = matrix.length;

        for (int i = 0; i < m; ++i) {
            if (isPalindrome(matrix[i])) {
                return i;
            }
        }

        return -1;
    }

    private void transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = i; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public String pattern(int[][] matrix) {
        // Code here
        int rowResult = checkPalindrome(matrix);

        if (rowResult != -1) {
            return rowResult + " " + "R";
        }

        transpose(matrix);

        int colResult = checkPalindrome(matrix);

        if (colResult != -1) {
            return colResult + " " + "C";
        }

        return "-1";
    }
}
