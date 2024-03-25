import java.util.Scanner;

class Solution {
    public int minimumLength(String s) {
        if (s.length() == 1) return 1;

        boolean canContinue;

        do {
            canContinue = false;

            for (char ch = 'a'; ch <= 'c'; ++ch) {
                if (s.charAt(0) == s.charAt(s.length() - 1)) {
                    canContinue = true;
                    break;
                }
            }
            if (canContinue) {
                int idx = 1;
                int prefixLen = 1;
                int suffixLen = 1;
                while (idx < s.length() && s.charAt(idx) == s.charAt(0)) {
                    ++prefixLen;
                    ++idx;
                }
                idx = s.length() - 2;
                while (idx >= 0 && s.charAt(idx) == s.charAt(s.length() - 1)) {
                    ++suffixLen;
                    --idx;
                }
                if (prefixLen + suffixLen >= s.length()) return 0;
                s = s.substring(prefixLen, s.length() - suffixLen);
            }
        } while (canContinue && s.length() > 1);

        return s.length();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minimumLength(s));
        }

        sc.close();
    }
}
