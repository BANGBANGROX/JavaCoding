import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
         int n = num.length();

         if (n <= k) return "0";

         if (k == 0) return num;

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && num.charAt(i) < st.peek() && k > 0) {
                --k;
                st.pop();
            }
            st.push(num.charAt(i));
            if (st.size() == 1 && st.peek() == '0') st.pop();
        }

        while (!st.isEmpty() && k > 0) {
            --k;
            st.pop();
        }

        while (!st.isEmpty()) {
            ans.append(st.peek());
            st.pop();
        }

        ans = ans.reverse();

        if (ans.isEmpty()) ans = new StringBuilder("0");

        return new String(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String num = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.removeKdigits(num, k));
        }

        sc.close();
    }
}
