// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
        }
    }
}// } Driver Code Ends


class Solution
{
    private static int compute(int a, int b, char operation) {
        if (operation == '+') return a + b;

        if (operation == '-') return a - b;

        if (operation == '*') return a * b;

        return a / b;
    }

    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s) {
        // Your code here
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                st.push(s.charAt(i) - '0');
                continue;
            }
            int b = st.peek();
            st.pop();
            int a = st.peek();
            st.pop();
            st.push(compute(a, b, s.charAt(i)));
        }

        return st.peek();
    }
}