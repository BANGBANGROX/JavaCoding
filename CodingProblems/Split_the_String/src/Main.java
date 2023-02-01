// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            String s = br.readLine().trim();

            ot.println(new Solution().splitString(n, s));
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int splitString(int n, String s) {
        // Code Here.
        int[] suffix = new int[n];
        int prefixMask = (1 << (s.charAt(0) - 'a'));
        int ans = 0;

        suffix[n - 1] = (1 << (s.charAt(n - 1) - 'a'));

        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = (suffix[i + 1] | (1 << (s.charAt(i) - 'a')));
        }

        for (int i = 1; i < n; ++i) {
            int suffixMask = suffix[i];
            int currentCount = 0;
            for (int bit = 25; bit >= 0; --bit) {
                int bit1 = (prefixMask & (1 << bit));
                int bit2 = (suffixMask & (1 << bit));
                if (bit1 > 0 && bit2 > 0) ++currentCount;
            }
            ans = Math.max(ans, currentCount);
            prefixMask |= (1 << (s.charAt(i) - 'a'));
        }

        return ans;
    }
}