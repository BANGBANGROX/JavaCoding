// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int longestSubstring(String s) {
        // code here
        int n = s.length();
        int ans = 0;
        int mask = 0;
        HashMap<Integer, Integer> mapMask = new HashMap<>();

        mapMask.put(0, -1);

        for (int i = 0; i < n; ++i) {
            mask ^= (1 << (s.charAt(i) - 'a'));
            if (mapMask.containsKey(mask)) {
                ans = Math.max(ans, i - mapMask.get(mask));
            }
            else {
                mapMask.put(mask, i);
            }
            for (int j = 0; j < 26; ++j) {
                int newMask = mask ^ (1 << j);
                if (mapMask.containsKey(newMask)) {
                    ans = Math.max(ans, i - mapMask.get(newMask));
                }
            }
        }

        return ans;
    }
};