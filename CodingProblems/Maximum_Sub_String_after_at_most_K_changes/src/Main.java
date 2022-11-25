//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int characterReplacement(String s, int k) {
        // code here
        int n = s.length();
        int ans = 0;
        int maxChars = -1;
        Map<Character, Integer> count = new HashMap<>();
        int l = 0;

        for (int r = 0; r < n; ++r) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxChars = Math.max(maxChars, count.get(s.charAt(r)));
            int differentChars = (r - l + 1 - maxChars);
            if (differentChars > k) {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}