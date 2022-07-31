//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int MinSquares(int n) {
        // Code here
        int[] dp = new int[n + 1];
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i * i <= n; ++i) {
            nums.add(i);
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int num : nums) {
            for (int i = 1; i <= n; ++i) {
                if (num <= i) dp[i] = Math.min(dp[i], dp[i - num] + 1);
            }
        }

        return dp[n];
    }
}