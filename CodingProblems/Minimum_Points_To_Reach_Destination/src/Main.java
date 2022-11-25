//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for(int i = 0;i<m;i++)
                for(int j = 0;j<n;j++)
                    points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points,m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minPoints(int[][] points, int m, int n) {
        // Your code goes here
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.min(points[m - 1][n - 1], 0);

        for (int i = m - 2; i >= 0; --i) {
            dp[i][n - 1] = dp[i + 1][n - 1] - points[i][n - 1];
            if (dp[i][n - 1] > 0) dp[i][n - 1] = 0;
        }

        for (int i = n - 2; i >= 0; --i) {
            dp[m - 1][i] = dp[m - 1][i + 1] - points[m - 1][i];
            if (dp[m - 1][i] > 0) dp[m - 1][i] = 0;
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + points[i][j];
                if (dp[i][j] > 0) dp[i][j] = 0;
            }
        }

        return Math.abs(dp[0][0]) + 1;
    }
}