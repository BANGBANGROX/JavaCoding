import java.util.Scanner;

class Solution {
    private int[] findLPS(String s) {
       int n = s.length();
       int[] lps = new int[n];
       int len = 0;
       int i = 1;

       while (i < n) {
           if (s.charAt(i) == s.charAt(len)) {
               ++len;
               lps[i] = len;
               ++i;
           }
           else {
               if (len == 0) ++i;
               else len = lps[len - 1];
           }
       }

       return lps;
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        int[] lps = findLPS(needle);

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                if (j == n) return i - j;
            }
            else {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String haystack = sc.next();
            String needle = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.strStr(haystack, needle));
        }

        sc.close();
    }
}
