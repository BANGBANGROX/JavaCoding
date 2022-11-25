//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    public int findMaxLen(String s) {
        // code here
        int open = 0;
        int close = 0;
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') ++open;
            else ++close;
            if (open == close) ans = Math.max(ans, 2 * open);
            if (open < close) {
                open = close = 0;
            }
        }

        open = close = 0;

        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '(') ++open;
            else ++close;
            if (open == close) ans = Math.max(ans, 2 * open);
            if (open > close) {
                open = close = 0;
            }
        }

        return ans;
    }
}