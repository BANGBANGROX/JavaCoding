import java.util.Map;
import java.util.Scanner;

class Solution {
    public int romanToDecimal(final String s) {
        // code here
        final int n = s.length();
        final Map<Character, Integer> value = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            final int firstValue = value.get(s.charAt(i));

            if (i + 1 < n && value.get(s.charAt(i + 1)) > firstValue) {
                answer += (value.get(s.charAt(i + 1)) - firstValue);
                ++i;
            } else {
                answer += firstValue;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().romanToDecimal(scanner.next()));
       }
       
       scanner.close();
   }
}
