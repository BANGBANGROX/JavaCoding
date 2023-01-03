//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                    new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    private int precedence(char ch) {
        if (ch == '-' || ch == '+') return 1;

        if (ch == '*' || ch == '/') return 2;

        if (ch == '^') return 3;

        return 0;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert an infix expression to a postfix expression.
    public String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : exp.toCharArray()) {
            if (!isOperator(ch)) {
                if (ch == '(' || ch == ')') {
                    if (ch == '(') st.push(ch);
                    else {
                        while (!st.isEmpty() && st.peek() != '(') {
                            ans.append(st.pop());
                        }
                        st.pop();
                    }
                }
                else ans.append(ch);
            }
            else {
                while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }
}