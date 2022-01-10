import java.util.Scanner;

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int opening = 0;
        int closing = 0;
        int maxLength = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') ++opening;
            else ++closing;
            if (opening == closing) maxLength = Math.max(maxLength, 2 * opening);
            else if (closing > opening) opening = closing = 0;
        }

        opening = closing = 0;

        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '(') ++opening;
            else ++closing;
            if (opening == closing) maxLength = Math.max(maxLength, 2 * opening);
            else if (closing < opening) opening = closing = 0;
        }

        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.longestValidParentheses(s));
        }

        sc.close();
    }
}
