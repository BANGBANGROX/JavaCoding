import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != '*') st.push(i);
            else if (!st.isEmpty()) st.pop();
        }

        while (!st.isEmpty()) {
            ans.append(s.charAt(st.pop()));
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
            System.out.println(solution.removeStars(s));
        }

        sc.close();
    }
}
