//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minOperation(String s) {
        // code here
        int n = s.length();
        int ans = n;

        for (int i = 0; i < n / 2; ++i) {
            boolean isPossible = true;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(j) != s.charAt(i + j + 1)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) ans = n - i;
        }

        return ans;
    }
}