//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String buildLowestNumber(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                --k;
            }
            st.push(ch);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            --k;
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        int idx = 0;

        while (idx < ans.length() && ans.charAt(idx) == '0') ++idx;

        return ans.substring(idx).length() == 0 ? "0" : ans.substring(idx);
    }
}