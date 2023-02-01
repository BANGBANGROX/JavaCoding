//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] in_line = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(in_line[0]);
            int Sum = Integer.parseInt(in_line[1]);

            Solution ob = new Solution();
            System.out.println(ob.countWays(n, Sum));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long countWays(int n, int sum) {
        // code here
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][sum + 1];

        for (int i = 1; i <= Math.min(9, sum); ++i) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                for (int dig = 0; dig <= Math.min(9, j); ++dig) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - dig]) % MOD;
                }
            }
        }

        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}