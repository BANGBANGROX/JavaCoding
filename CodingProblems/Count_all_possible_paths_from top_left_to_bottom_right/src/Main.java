//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] input;
            input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    long numberOfPaths(int m, int n) {
        // code here
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[m][n];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) dp[i][j] = 1;
                else if (i == m - 1) dp[i][j] = dp[i][j + 1];
                else if (j == n - 1) dp[i][j] = dp[i + 1][j];
                else dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % MOD;
            }
        }

        return dp[0][0];
    }
}