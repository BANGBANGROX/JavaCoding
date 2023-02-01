//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKDigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKDigits(String s, int k) {
        // code here
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && k > 0 && s.charAt(st.peek()) > s.charAt(i)) {
                --k;
                st.pop();
            }
            st.push(i);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            --k;
        }

        while (!st.isEmpty()) {
            ans.append(s.charAt(st.pop()));
        }

        if (ans.isEmpty()) return "0";

        ans.reverse();

        int ind = 0;

        while (ind < ans.length() && ans.charAt(ind) == '0') {
            ++ind;
        }

        String finalResult = ans.substring(ind);

        if (finalResult.isEmpty()) return "0";

        return finalResult;
    }
}