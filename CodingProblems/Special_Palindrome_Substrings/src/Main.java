//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution obj = new Solution();
            int ans = obj.specialPalindrome(s1, s2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    public int specialPalindrome(String a, String b) {
        //Code Here
        int m = a.length();
        int n = b.length();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= m - n; ++i) {
            int currentCost = 0;
            for (int j = 0; j < n; ++j) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    ++currentCost;
                }
            }
            int left = 0;
            int right = m - 1;
            while (left < right) {
                if (i <= left && left < i + n && right < i + n && b.charAt(left - i) != b.charAt(right - i)) {
                    break;
                }
                char leftChar = a.charAt(left);
                char rightChar = b.charAt(right);
                if (i <= left && left < i + n) {
                    leftChar = b.charAt(left - i);
                }
                if (i <= right && right < i + n) {
                    rightChar = b.charAt(right - i);
                }
                if (leftChar != rightChar) {
                    ++currentCost;
                }
                ++left;
                --right;
            }
            if (left >= right) {
                ans = Math.min(ans, currentCost);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}