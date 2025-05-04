import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int numEquivDominoPairs(final int[][] dominoes) {
        final Map<String, Integer> count = new HashMap<>();
        int answer = 0;

        for (int[] domino : dominoes) {
            final String forwardString = domino[0] + "#" + domino[1];
            final String reverseString = domino[1] + "#" + domino[0];
            final int change;

            if (forwardString.equals(reverseString)) {
                change = count.getOrDefault(forwardString, 0);
            } else {
                change = count.getOrDefault(forwardString, 0) +
                        count.getOrDefault(reverseString, 0);
            }

            answer += change;
            count.put(forwardString, count.getOrDefault(forwardString, 0) + 1);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[][] dominoes = new int[n][2];
           for (int i = 0; i < n; ++i) {
               dominoes[i][0] = scanner.nextInt();
               dominoes[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().numEquivDominoPairs(dominoes));
       }
       
       scanner.close();
   }
}
