//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main (String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
            System.out.println (new Solution().substrCount (s, k));
        }

    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private long substrCountUtil(String s, int k) {
        int totalDistinct = 0;
        int n = s.length();
        int[] count = new int[26];
        int l = 0;
        long ans = 0;

        for (int r = 0; r < n; ++r) {
            ++count[s.charAt(r) - 'a'];
            if (count[s.charAt(r) - 'a'] == 1) ++totalDistinct;
            while (l < n && totalDistinct > k) {
                --count[s.charAt(l) - 'a'];
                if (count[s.charAt(l) - 'a'] == 0) --totalDistinct;
                ++l;
            }
            ans += (r - l + 1);
        }

        return ans;
    }

    public long substrCount (String s, int k) {
        // your code here
        return substrCountUtil(s, k) - substrCountUtil(s, k - 1);
    }
}