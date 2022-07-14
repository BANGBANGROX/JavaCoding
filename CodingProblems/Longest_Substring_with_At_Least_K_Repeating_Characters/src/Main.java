import java.util.Scanner;

class Solution {
    private int longestSubstringUtil(String s, int start, int end, int k) {
       if (end < k) return 0;

       int[] count = new int[26];

       for (int i = start; i < end; ++i) {
           ++count[s.charAt(i) - 'a'];
       }

       for (int mid = start; mid < end; ++mid) {
           if (count[s.charAt(mid) - 'a'] >= k) continue;
           int midNext = mid + 1;
           while (midNext < end && count[s.charAt(midNext) - 'a'] < k) ++midNext;
           return Math.max(longestSubstringUtil(s, start, mid, k), longestSubstringUtil(s, midNext, end, k));
       }

       return (end - start);
    }

    public int longestSubstring(String s, int k) {
         return longestSubstringUtil(s, 0, s.length(), k);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.longestSubstring(s, k));
        }

        sc.close();
    }
}
