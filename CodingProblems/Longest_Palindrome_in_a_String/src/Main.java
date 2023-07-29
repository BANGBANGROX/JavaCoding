//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String longestPalin(String s) {
        // code here
        int n = s.length();
        int maximumLength = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] |= dp[i + 1][j - 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (len > maximumLength) {
                        maximumLength = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maximumLength - 1);
    }
}