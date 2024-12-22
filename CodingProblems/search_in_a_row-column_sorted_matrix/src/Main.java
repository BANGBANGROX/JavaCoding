//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean matSearch(int[][] mat, int x) {
        // your code here
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            }
            else if (mat[i][j] > x) {
                --j;
            } else {
                ++i;
            }
        }

        return false;
    }
}