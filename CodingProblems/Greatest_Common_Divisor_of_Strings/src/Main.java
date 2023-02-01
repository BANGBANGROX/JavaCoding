import java.util.Scanner;

class Solution {
    private boolean check(String pattern, String s) {
        String init = pattern;
        StringBuilder patternBuilder = new StringBuilder(pattern);

        while (patternBuilder.length() < s.length()) {
            patternBuilder.append(init);
        }

        pattern = patternBuilder.toString();

        return pattern.equals(s);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);

        int n = str2.length();

        for (int len = n; len > 0; --len) {
            String pattern1 = str2.substring(0, len);
            String pattern2 = str2.substring(0, len);
            if (check(pattern1, str2) && check(pattern2, str1)) return str2.substring(0, len);
        }

        return "";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.gcdOfStrings(str1, str2));
        }

        sc.close();
    }
}
