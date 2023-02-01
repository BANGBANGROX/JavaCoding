//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if (ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean valid(String s) {
        // code here
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if (st.isEmpty()) return false;
                char last = st.pop();
                if ((ch == '}' && last != '{') ||
                        (ch == ']' && last != '[') ||
                        (ch == ')' && last != '(')) return false;

            }
        }

        return st.isEmpty();
    }
}