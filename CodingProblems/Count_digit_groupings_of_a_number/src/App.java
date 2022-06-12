// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    private int n;
    private int[][] dp;
    private String s;

    private int TotalCount(int index, int currentSum) {
        if (index == n)
            return 1;

        if (dp[index][currentSum] != -1)
            return dp[index][currentSum];

        int newSum = 0;
        int ans = 0;

        for (int i = index; i < n; ++i) {
            newSum += (s.charAt(i) - '0');
            if (newSum >= currentSum) {
                ans += TotalCount(i + 1, newSum);
            }
        }

        return dp[index][currentSum] = ans;
    }

    public int TotalCount(String str) {
        // Code here
        s = str;
        n = str.length();
        dp = new int[n][1000];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return TotalCount(0, 0);
    }
}