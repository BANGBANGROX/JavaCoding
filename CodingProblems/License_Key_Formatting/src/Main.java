//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.ReFormatString(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String ReFormatString(String s, int k) {
        // code here
        StringBuilder chars = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) ch = Character.toUpperCase(ch);
                chars.append(ch);
            }
        }

        int len = chars.length();
        int rem = len % k;
        int i = 0;
        int cnt = 0;

        while (i < rem) {
            ans.append(chars.charAt(i));
            ++i;
        }

        if (!ans.isEmpty() && i < len) ans.append('-');

        while (i < len) {
            if (cnt == k) {
                ans.append('-');
                cnt = 0;
            }
            ans.append(chars.charAt(i));
            ++i;
            ++cnt;
        }

        return ans.toString();
    }
}