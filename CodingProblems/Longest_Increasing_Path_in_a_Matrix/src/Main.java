//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.longestIncreasingPath(arr, n, m));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int[][] matrix;
    private int[][] dp;
    private int m;
    private int n;

    private int longestIncreasingPathUtil(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        int ans = 0;

        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n
                    && matrix[newX][newY] > matrix[x][y]) {
                ans = Math.max(ans, longestIncreasingPathUtil(newX, newY) + 1);
            }
        }

        return dp[x][y] = ans;
    }

    /*You are required to complete this method*/
    public int longestIncreasingPath(int[][] matrix, int m, int n) {
        // Code here
        this.matrix = matrix;
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dp[i][j] == -1) {
                    ans = Math.max(ans, longestIncreasingPathUtil(i, j));
                }
            }
        }

        return ans;
    }
}