// { Driver Code Starts
//Initial Template for Java

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
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int n;
    private int[][] dp;
    private int[][] cost;
    private int fullMask;

    private int totalCostUtil(int node, int mask) {
        if (mask == fullMask) return cost[node][0];

        if (dp[node][mask] != -1) return dp[node][mask];

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if ((mask & (1 << i)) > 0) continue;
            ans = Math.min(ans, totalCostUtil(i, mask | (1 << i)) + cost[node][i]);
        }

        return dp[node][mask] = ans;
    }

    public int total_cost(int[][] cost) {
        // Code here
        n = cost.length;
        this.cost = cost;
        dp = new int[n][(1 << n)];
        fullMask = (1 << n) - 1;

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return totalCostUtil(0, 1);
    }
}