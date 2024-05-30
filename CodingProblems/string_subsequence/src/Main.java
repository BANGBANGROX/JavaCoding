//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    private long[][] dp;
    private String s1;
    private String s2;

    private long countWaysHandler(int i, int j) {
        final int MOD = (int) 1e9 + 7;

        if (j >= s2.length()) return 1;

        if (i >= s1.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = (countWaysHandler(i + 1, j) + (s1.charAt(i) == s2.charAt(j) ? countWaysHandler(i + 1, j + 1) : 0)) % MOD;
    }

    public int countWays(String s1, String s2) {
        // code here
        this.s1 = s1;
        this.s2 = s2;
        dp = new long[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); ++i) {
            Arrays.fill(dp[i], -1);
        }

        return (int) countWaysHandler(0, 0);
    }
}
