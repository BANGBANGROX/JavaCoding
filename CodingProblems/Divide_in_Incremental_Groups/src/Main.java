//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int n, int k) {
        // Code here
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; ++i) {
            for (int j = i; j <= n; ++j) {
                if (i == j) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i][j - i];
            }
        }

        return dp[k][n];
    }
}