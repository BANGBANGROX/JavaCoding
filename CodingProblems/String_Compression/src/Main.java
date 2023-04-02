import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        ArrayList<Character> result = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int cnt = 1;
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                ++cnt;
                ++i;
            }
            result.add(chars[i]);
            if (cnt != 1) {
                String num = String.valueOf(cnt);
                int idx = 0;
                while (idx < num.length()) {
                    result.add(num.charAt(idx));
                    ++idx;
                }
            }
        }

        for (int i = 0; i < result.size(); ++i) {
            chars[i] = result.get(i);
        }

        return result.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            char[] chars = new char[n];
            for (int i = 0; i < n; ++i) {
                chars[i] = sc.next().charAt(0);
            }

            Solution solution = new Solution();
            System.out.println(solution.compress(chars));
        }

        sc.close();
    }
}
