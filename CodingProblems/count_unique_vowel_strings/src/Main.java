import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int vowelCount(final String s) {
        final Map<Character, Integer> count = new HashMap<>();

        for (final char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count.put(ch, count.getOrDefault(ch, 0) + 1);
            }
        }

        if (count.isEmpty()) {
            return 0;
        }

        int answer = getFactorial(count.size());

        for (final Map.Entry<Character, Integer> entry : count.entrySet()) {
            answer *= entry.getValue();
        }

        return answer;
    }

    private int getFactorial(final int num) {
        int result = 1;

        for (int i = 2; i <= num; ++i) {
            result *= i;
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().vowelCount(scanner.next()));
       }
       
       scanner.close();
   }
}
