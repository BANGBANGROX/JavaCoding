//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private long[][] dp;

    private long countStringsUtil(int index, int n, int previousChar) {
        if (index >= n) return 1;

        if (dp[index][previousChar] != -1) return dp[index][previousChar];

        long MOD = (int) 1e9 + 7;

        if (previousChar == 1) return dp[index][previousChar] = countStringsUtil(index + 1, n, 0)
                % MOD;

        return dp[index][previousChar] = (countStringsUtil(index + 1, n, 0) +
                countStringsUtil(index + 1, n, 1)) % MOD;
    }

    long countStrings(int n) {
        // code here
        dp = new long[n][2];

        for (int i = 0; i < n; ++i) {
            dp[i][0] = dp[i][1] = -1;
        }

        return countStringsUtil(0, n, 0);
    }
}