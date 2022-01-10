// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for(int i = 0;i<m;i++)
                coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}    // } Driver Code Ends


class Solution{
    final int  inf = (int)1e9;

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        int[] dp = new int[V + 1];

        for (int i = 1; i <= V; ++i) {
            dp[i] = inf;
        }

        for (int i = 0; i < M; ++i) {
            for (int sum = 1; sum <= V; ++sum) {
                if (coins[i] > sum || dp[sum - coins[i]] == inf) continue;
                dp[sum] = Math.min(dp[sum], dp[sum - coins[i]] + 1);
            }
        }

        return dp[V] == inf ? -1 : dp[V];
    }
}