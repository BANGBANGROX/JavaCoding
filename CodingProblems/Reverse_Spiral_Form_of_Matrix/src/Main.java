//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input;
            input = read.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);
            String[] s1 = read.readLine().trim().split("\\s+");
            int[][] a = new int[R][C];
            for (int i = 0; i < R * C; i++)
                a[i / C][i % C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R, C, a);
            for (int an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public int[] reverseSpiral(int m, int n, int[][] matrix) {
        // code here
        int[] ans = new int[m * n];
        int firstRow = 0;
        int lastRow = m - 1;
        int firstCol = 0;
        int lastCol = n - 1;
        int idx = 0;

        while (firstRow <= lastRow && firstCol <= lastCol) {
            // First Row
            for (int i = firstCol; i <= lastCol; ++i) {
                ans[idx] = matrix[firstRow][i];
                ++idx;
            }
            ++firstRow;
            if (firstRow > lastRow) break;
            // Last Col
            for (int i = firstRow; i <= lastRow; ++i) {
                ans[idx] = matrix[i][lastCol];
                ++idx;
            }
            --lastCol;
            if (firstCol > lastCol) break;
            // Last Row
            for (int i = lastCol; i >= firstCol; --i) {
                ans[idx] = matrix[lastRow][i];
                ++idx;
            }
            --lastRow;
            // First Col
            for (int i = lastRow; i >= firstRow; --i) {
                ans[idx] = matrix[i][firstCol];
                ++idx;
            }
            ++firstCol;
        }

        int l = 0;
        int r = idx - 1;

        while (l < r) {
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
            ++l;
            --r;
        }

        return ans;
    }
}