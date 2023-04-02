//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");

            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);

            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String[] S1 = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int uniquePaths(int m, int n, int[][] grid) {
        // code here
        if (grid[0][0] == 0 || grid[m - 1][n - 1] == 0) return 0;

        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[m][n];

        for (int i = m - 2; i >= 0; --i) {
            if (grid[i][n - 1] == 0) break;
            dp[i][n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; --i) {
            if (grid[m - 1][i] == 0) break;
            dp[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (grid[i][j] == 0) continue;
                dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % MOD;
            }
        }

        return (int) dp[0][0];
    }
}