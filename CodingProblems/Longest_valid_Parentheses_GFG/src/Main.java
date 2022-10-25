//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int maxLength(String s) {
        // code here
        int open = 0;
        int close = 0;
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') ++open;
            else ++close;
            if (open == close) ans = Math.max(ans, 2 * open);
            else if (open < close) {
                open = 0;
                close = 0;
            }
        }

        open = close = 0;

        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '(') ++open;
            else ++close;
            if (open == close) ans = Math.max(ans, 2 * open);
            else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return ans;
    }
}