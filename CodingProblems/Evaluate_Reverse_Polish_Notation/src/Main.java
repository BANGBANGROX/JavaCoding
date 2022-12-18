import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> st = new Stack<>();

         for (String token : tokens) {
             if (Character.isDigit(token.charAt(0)) || (token.charAt(0) == '-' && token.length() > 1)) {
                 if (token.charAt(0) == '-') {
                     st.push(-1 * Integer.parseInt(token.substring(1)));
                 }
                 else {
                     st.push(Integer.parseInt(token));
                 }
             }
             else {
                 int b = st.pop();
                 int a = st.pop();
                 int result;
                 if (token.charAt(0) == '*') {
                     result = a * b;
                 }
                 else if (token.charAt(0) == '+') {
                     result = a + b;
                 }
                 else if (token.charAt(0) == '/') {
                     result = a / b;
                 }
                 else {
                     result = a - b;
                 }
                 st.push(result);
             }
         }

         return st.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] tokens = new String[n];

            for (int i = 0; i < n; ++i) {
                tokens[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.evalRPN(tokens));
        }

        sc.close();
    }
}
