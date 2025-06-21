import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int minimumDeletions(final String word, final int k) {
        final Map<Character, Integer> count = new HashMap<>();
        int answer = word.length();

        for (final char ch : word.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (final int a : count.values()) {
            int difference = 0;
            for (final int b : count.values()) {
                if (a > b) {
                    difference += b;
                } else if (b > a + k) {
                    difference += (b - (a + k));
                }
            }
            answer = Math.min(answer, difference);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().minimumDeletions(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
