//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public long nthStair(int n) {
        // Code here
        final long mod = (long)1e9 + 7;
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            dp[i] = (Math.min(dp[i - 1], dp[i - 2]) + 1) % mod;
        }

        return dp[n];
    }
}