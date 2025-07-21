import java.util.Scanner;

class Solution {
    public String makeFancyString(final String s) {
        final StringBuilder answer = new StringBuilder();
        char lastChar = '#';
        int currentCount = 0;

        for (final char ch : s.toCharArray()) {
            if (ch != lastChar) {
                currentCount = 1;
                answer.append(ch);
                lastChar = ch;
            } else {
                ++currentCount;
                if (currentCount < 3) {
                    answer.append(ch);
                }
            }
        }

        return answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().makeFancyString(scanner.next()));
       }
       
       scanner.close();
   }
}
