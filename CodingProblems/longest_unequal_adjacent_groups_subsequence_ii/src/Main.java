import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> getWordsInLongestSubsequence(final String[] words, final int[] groups) {
        final List<String> answer = new ArrayList<>();
        final int n = words.length;
        final int[] dp = new int[n];
        final int[] lastIndex = new int[n];
        int maxFinalValue = 0;
        int maxFinalValueIdx = -1;

        Arrays.fill(lastIndex, -1);

        for (int i = 0; i < n; ++i) {
            int maxValue = 0;
            int maxValueIdx = -1;
            for (int j = 0; j < i; ++j) {
                if (words[j].length() == words[i].length() &&
                        getHammingDistance(words[i], words[j]) == 1 && groups[i] != groups[j]) {
                    if (maxValue < dp[j]) {
                        maxValue = dp[j];
                        maxValueIdx = j;
                    }
                }
            }
            if (maxValueIdx != -1) {
                dp[i] = maxValue + 1;
                lastIndex[i] = maxValueIdx;
            } else {
                dp[i] = 1;
            }
            if (maxFinalValue < dp[i]) {
                maxFinalValue = dp[i];
                maxFinalValueIdx = i;
            }
        }

        if (maxFinalValueIdx != -1) {
            while (maxFinalValueIdx != -1) {
                answer.add(words[maxFinalValueIdx]);
                maxFinalValueIdx = lastIndex[maxFinalValueIdx];
            }
            Collections.reverse(answer);
        }

        return answer;
    }

    private int getHammingDistance(final String s1, final String s2) {
        final int n = s1.length();
        int result = 0;

        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++result;
            }
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
           final int[] groups = new int[n];
           for (int i = 0; i < n; ++i) {
               groups[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getWordsInLongestSubsequence(words, groups));
       }
       
       scanner.close();
   }
}
