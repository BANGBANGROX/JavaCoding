import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            }
            else {
                char ch1 = st.peek();
                boolean a = (Character.isLowerCase(ch1) &&
                        !Character.isLowerCase(s.charAt(i)));
                boolean b = (!Character.isLowerCase(ch1) &&
                        Character.isLowerCase(s.charAt(i)));
                boolean c = Character.toLowerCase(ch1) ==
                        Character.toLowerCase(s.charAt(i));
                if ((a || b) && c) st.pop();
                else st.push(s.charAt(i));
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.makeGood(s));
        }

        sc.close();
    }
}
