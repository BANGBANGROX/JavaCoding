// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String[] a = in.readLine().trim().split("\\s+");
            int[] p = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class Pair {
        String first;
        int second;

        public Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private Pair[][] dp;

    private Pair matrixChainOrderUtil(int[] p, int i, int j) {
        if (i == j) return new Pair("" + (char)(i - 1 + 'A'), 0);

        if (dp[i][j] != null) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        String s = "";

        for (int k = i; k < j; ++k) {
            Pair p1 = matrixChainOrderUtil(p, i, k);
            Pair p2 = matrixChainOrderUtil(p, k + 1, j);
            int current = p[i - 1] * p[k] * p[j] + p1.second + p2.second;
            if (ans >= current) {
                ans = current;
                s = p1.first + p2.first;
            }
        }

        return dp[i][j] = new Pair('(' + s + ')', ans);
    }

    public String matrixChainOrder(int[] p, int n){
        // code here
        dp = new Pair[n][n];

        return matrixChainOrderUtil(p, 1, n - 1).first;
    }
}