import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private int k;
    private String s;

    public String longestSubsequenceRepeatedK(final String s, final int k) {
        this.s = s;
        this.k = k;
        final int[] count = new int[26];
        final List<Character> validCharacters = new ArrayList<>();
        final Queue<String> stringQueue = new LinkedList<>();
        String answer = "";

        for (final char ch : s.toCharArray()) {
            ++count[ch - 'a'];
            if (count[ch - 'a'] == k) {
                validCharacters.add(ch);
            }
        }

        Collections.sort(validCharacters);

        stringQueue.add("");

        while (!stringQueue.isEmpty()) {
            final String top = stringQueue.poll();
            answer = top;
            for (final char ch : validCharacters) {
                final String newString = top + ch;
                if (isValid(newString)) {
                    stringQueue.add(newString);
                }
            }
        }

        return answer;
    }

    private boolean isValid(final String subsequence) {
        int i = 0;
        int j = 0;
        int m = subsequence.length();
        int n = s.length();
        int cnt = 0;

        while (i < m && j < n) {
            if (subsequence.charAt(i) == s.charAt(j)) {
                ++i;
                if (i == m) {
                    i = 0;
                    ++cnt;
                    if (cnt == k) {
                        return true;
                    }
                }
            }
            ++j;
        }

        return false;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().longestSubsequenceRepeatedK(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
