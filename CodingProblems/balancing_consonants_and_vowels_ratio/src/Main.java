import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int countBalanced(final String[] arr) {
        // code here
        final Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        int runningDifferenceSum = 0;

        for (final String s : arr) {
            final List<Integer> counts = getConsonantsAndVowelsCount(s);
            final int consonantsCount = counts.get(0);
            final int vowelsCount = counts.get(1);
            final int countDifference = consonantsCount - vowelsCount;

            runningDifferenceSum += countDifference;

            if (runningDifferenceSum == 0) {
                ++answer;
            }

            answer += count.getOrDefault(runningDifferenceSum, 0);

            count.put(runningDifferenceSum, count.getOrDefault(runningDifferenceSum, 0) + 1);
        }

        return answer;
    }

    private List<Integer> getConsonantsAndVowelsCount(final String s) {
        int consonantsCount = 0;
        int vowelsCount = 0;

        for (final char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                ++vowelsCount;
            } else {
                ++consonantsCount;
            }
        }

        return List.of(consonantsCount, vowelsCount);
    }

    private boolean isVowel(final char ch) {
        return List.of('a', 'e', 'i', 'o', 'u').contains(ch);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final String[] arr = new String[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.next();
           }

           System.out.println(new Solution().countBalanced(arr));
       }
       
       scanner.close();
   }
}
