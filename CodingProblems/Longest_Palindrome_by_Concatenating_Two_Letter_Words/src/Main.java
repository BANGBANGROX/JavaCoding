import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        int ans = 0;
        boolean twoSame = false;

        for (String word : words) {
            if (mp.containsKey(word)) {
                mp.put(word, mp.get(word) + 1);
            }
            else {
                mp.put(word, 1);
            }
        }

        for (String word : words) {
            if (!mp.containsKey(word)) continue;
            if (word.charAt(0) != word.charAt(1)) {
                String rev = word.charAt(1) + "" +  word.charAt(0);
                if (mp.containsKey(rev)) {
                    ans += 2 * Math.min(mp.get(word), mp.get(rev));
                    mp.remove(rev);
                    mp.remove(word);
                }
            }
            else {
                    int cnt = mp.get(word);
                    if (cnt % 2 == 0) ans += 2 * cnt;
                    else {
                        ans += 2 * (cnt - 1);
                        if (!twoSame) {
                            ans += 2;
                            twoSame = true;
                        }
                    }
                mp.remove(word);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) words[i] = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.longestPalindrome(words));
        }

        sc.close();
    }
}
