//{ Driver Code Starts

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
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int checkCompressed(String s, String t) {
        // code here
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;

        while (j < n) {
            if (Character.isDigit(t.charAt(j))) {
                StringBuilder num = new StringBuilder();
                while (j < n && Character.isDigit(t.charAt(j))) {
                    num.append(t.charAt(j));
                    ++j;
                }
                i += Integer.parseInt(num.toString());
                if (i > m) return 0;
            }
            if (i == m) return j == n ? 1 : 0;
            if (j < n) {
                if (t.charAt(j) != s.charAt(i)) return 0;
                ++j;
                ++i;
            }
        }

        return i == m ? 1 : 0;
    }
}