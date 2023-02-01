//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            String[] s = in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if (g.isScramble(a, b)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private final HashMap<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        //code here
        if (s1.equals(s2)) return true;

        if (s1.length() <= 1) return false;

        String key = s1 + '-' + s2;

        if (dp.containsKey(key)) return dp.get(key);

        int n = s1.length();
        boolean res = false;

        for (int i = 1; i < n; ++i) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) ||
                    (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                            isScramble(s1.substring(i), s2.substring(0, n - i)))) {
                res = true;
                break;
            }
        }

        dp.put(key, res);

        return res;
    }
}
