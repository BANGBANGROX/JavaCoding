// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] A = read.readLine().split(" ");

            String S = A[0];
            String T = A[1];

            Solution ob = new Solution();
            System.out.println(ob.shortestUnSub(S,T));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int shortestUnSub(String s, String t) {
        // code here
        int m = s.length();
        int n = t.length();
        final int inf = (int) 1e9;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[i], inf);
        }

        for (int i = 1; i <= m; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int k = j;
                while (k >= 0 && s.charAt(i) != t.charAt(k)) --k;
                if (k < 0) dp[i + 1][j + 1] = 1;
                else dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i][k] + 1);
            }
        }

        return dp[m][n] >= inf ? -1 : dp[m][n];
    }
}