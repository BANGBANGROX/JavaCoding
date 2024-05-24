import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int countChangesNeeded(int[] count) {
        assert count.length > 0;

        int maxValue = Arrays.stream(count).max().getAsInt();
        int result = -1 * maxValue;

        for (int val : count) {
            if (val <= maxValue) {
                result += val;
            }
        }

        return result;
    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int answer = 0;
        int left = 0;
        int n = s.length();

        for (int right = 0; right < n; ++right) {
            ++count[s.charAt(right) - 'A'];
            while (countChangesNeeded(count) > k) {
                --count[s.charAt(left) - 'A'];
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

            System.out.println(new Solution().characterReplacement(s, k));
        }

        sc.close();
    }
}
