//{ Driver Code Starts
// Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private long getUniqueSubsequences(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        int[] lastIndex = new int[26];

        Arrays.fill(lastIndex, -1);
        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            char ch = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];
            if (lastIndex[ch - 'a'] != -1) {
                dp[i] -= dp[lastIndex[ch - 'a'] - 1];
            }
            lastIndex[ch - 'a'] = i;
        }

        return dp[n];
    }

    public String betterString(String str1, String str2) {
        // Code here
        return getUniqueSubsequences(str1) >= getUniqueSubsequences(str2) ? str1 : str2;
    }
}