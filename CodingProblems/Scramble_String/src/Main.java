import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private final HashMap<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        if (s1.equals(s2)) return true;

        String s = s1 + '*' + s2;

        if (dp.containsKey(s)) return dp.get(s);

        boolean ans = false;
        int n = s1.length();

        for (int i = 1; i < n; ++i) {
            String x = s1.substring(0, i);
            String y = s1.substring(i);
            String t1 = s2.substring(0, i);
            String t2 = s2.substring(i);
            String t3 = s2.substring(n - i);
            String t4 = s2.substring(0, n - i);
            if ((isScramble(x, t1) && isScramble(y, t2)) ||
                    (isScramble(x, t3) && isScramble(y, t4))) {
                ans = true;
                break;
            }
        }

        dp.put(s, ans);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.isScramble(s1, s2));
        }

        sc.close();
    }
}
