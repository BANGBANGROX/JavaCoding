import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currentNumber = 0;
        int n = s.length();
        int ans = 0;
        char currentOperation = '+';

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == n - 1) {
                if (currentOperation == '+') {
                    st.push(currentNumber);
                }
                if (currentOperation == '-') {
                    st.push(-1 * currentNumber);
                }
                if (currentOperation == '*') {
                    int a = st.pop();
                    st.push(a * currentNumber);
                }
                if (currentOperation == '/') {
                    int a = st.pop();
                    st.push(a / currentNumber);
                }
                currentOperation = ch;
                currentNumber = 0;
            }
        }

        while (!st.empty()) {
            ans += st.pop();
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.nextLine();

            Solution solution = new Solution();
            System.out.println(solution.calculate(s));
        }

        sc.close();
    }
}
