import java.util.Scanner;

class Solution {
    public int[] longestCommonPrefix(final String[] words) {
        final int n = words.length;
        final int[] prefix = new int[n];
        final int[] suffix = new int[n];
        final int[] lengths = new int[n]; // lengths[i] = lcp(words[i - 1], words[i])
        final int[] answer = new int[n];

        for (int i = 1; i < n; ++i) {
            lengths[i] = getCommonPrefixLength(words[i - 1], words[i]);
            prefix[i] = Math.max(prefix[i - 1], lengths[i]);
        }

        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = Math.max(suffix[i + 1], lengths[i + 1]);
        }

        for (int i = 0; i < n; ++i) {
            int result = 0;
            if (i > 0) {
                result = Math.max(result, prefix[i - 1]);
            }
            if (i + 1 < n) {
                result = Math.max(result, suffix[i + 1]);
            }
            if (i > 0 && i + 1 < n) {
                result = Math.max(result, getCommonPrefixLength(words[i - 1], words[i + 1]));
            }
            answer[i] = result;
        }

        return answer;
    }

    private int getCommonPrefixLength(final String s1, final String s2) {
        int result = 0;
        int i = 0;
        final int len = Math.min(s1.length(), s2.length());

        while (i < len && s1.charAt(i) == s2.charAt(i)) {
            ++i;
            ++result;
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final String[] words = new String[n];
           for (int i = 0; i < n; ++i) {
               words[i] = scanner.next();
           }

           final int[] answer = new Solution().longestCommonPrefix(words);
           for (final int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
