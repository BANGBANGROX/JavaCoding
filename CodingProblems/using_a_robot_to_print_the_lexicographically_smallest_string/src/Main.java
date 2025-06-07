import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String robotWithString(final String s) {
        final int[] count = new int[26];
        final StringBuilder answer = new StringBuilder();
        final Stack<Character> stack = new Stack<>();
        char minChar = 'a';

        for (final char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        for (final char ch : s.toCharArray()) {
            stack.push(ch);
            --count[ch - 'a'];
            while (minChar != 'z' && count[minChar - 'a'] == 0) {
                ++minChar;
            }
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                answer.append(stack.pop());
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
           System.out.println(new Solution().robotWithString(scanner.next()));
       }
       
       scanner.close();
   }
}
