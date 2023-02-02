import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private final HashMap<Character, Integer> ordering = new HashMap<>();

    private boolean customCompare(String a, String b) {
        // a <= b true
        // a > b false
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; ++i) {
            if (ordering.get(a.charAt(i)) > ordering.get(b.charAt(i))) return false;
            if (ordering.get(a.charAt(i)) < ordering.get(b.charAt(i))) return true;
        }

        return a.length() <= b.length();
    }

    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;

        for (int i = 0; i < 26; ++i) {
            ordering.put(order.charAt(i), i);
        }

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (!customCompare(words[i], words[j])) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }
            String order = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.isAlienSorted(words, order));
        }

        sc.close();
    }
}
