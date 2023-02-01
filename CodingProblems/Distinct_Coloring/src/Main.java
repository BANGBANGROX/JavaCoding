//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public long distinctColoring(int n, int[] r, int[] g, int[] b) {
        //code here
        long[][] dp = new long[n][3];

        dp[0][0] = r[0];
        dp[0][1] = g[0];
        dp[0][2] = b[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b[i];
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] input = read.readLine().trim().split("\\s+");
            int[] r = new int[N];
            for (int i = 0; i < N; i++)
                r[i] = Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[] g = new int[N];
            for (int i = 0; i < N; i++)
                g[i] = Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[] b = new int[N];
            for (int i = 0; i < N; i++)
                b[i] = Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends