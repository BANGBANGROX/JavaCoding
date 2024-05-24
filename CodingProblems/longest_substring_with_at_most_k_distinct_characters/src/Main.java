import java.util.Scanner;

class Solution {
    public int getLongestSubstringWithAtMostKDistinctCharacters(String s, int k) {
        int answer = 0;
        int n = s.length();
        int left = 0;
        int[] count = new int[26];
        int distinctChars = 0;

        for (int right = 0; right < n; ++right) {
            ++count[s.charAt(right) - 'a'];
            if (count[s.charAt(right) - 'a'] == 1) {
                ++distinctChars;
            }
            while (distinctChars > k) {
                --count[s.charAt(left) - 'a'];
                if (count[s.charAt(left) - 'a'] == 0) {
                    --distinctChars;
                }
                ++left;
            }
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            System.out.println(new Solution().getLongestSubstringWithAtMostKDistinctCharacters(s, k));
        }

        sc.close();
    }
}
