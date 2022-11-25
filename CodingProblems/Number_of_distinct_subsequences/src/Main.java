//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int distinctSubsequences(String s) {
        // code here
        final int MOD = (int) 1e9 + 7;
        int n = s.length();
        int[] dp = new int[n + 1];
        Map<Character, Integer> index = new HashMap<>();

        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            char ch = s.charAt(i - 1);
            dp[i] = (dp[i - 1] * 2) % MOD;
            if (index.containsKey(ch)) {
                int idx = index.get(ch);
                dp[i] = (dp[i] - dp[idx - 1] + MOD) % MOD;
            }
            index.put(ch, i);
        }

        return dp[n];
    }
}