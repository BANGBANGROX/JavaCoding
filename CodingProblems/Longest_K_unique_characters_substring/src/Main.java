//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestKSubstring(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestKSubstring(String s, int k) {
        // code here
        int[] count = new int[26];
        int done = 0;
        int maxLength = -1;
        int l = 0;
        int n = s.length();

        for (int r = 0; r < n; ++r) {
            char ch = s.charAt(r);
            ++count[ch - 'a'];
            if (count[ch - 'a'] == 1) ++done;
            while (done > k) {
                char next = s.charAt(l);
                --count[next - 'a'];
                if (count[next - 'a'] == 0) --done;
                ++l;
            }
            if (done == k) {
                if ((r - l + 1) > maxLength) {
                    maxLength = r - l + 1;
                }
            }
        }

        return maxLength;
    }
}
