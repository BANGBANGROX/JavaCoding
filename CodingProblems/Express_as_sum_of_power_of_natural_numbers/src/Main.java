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
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int numOfWays(int n, int x) {
        // code here
        final int MOD = (int) 1e9 + 7;
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            int coin = 1;
            for (int j = 0; j < x && coin <= n; ++j) {
                coin *= i;
            }
            if (coin > n) break;
            for (int sum = n; sum >= coin; --sum) {
                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }

        return (int) dp[n];
    }
}