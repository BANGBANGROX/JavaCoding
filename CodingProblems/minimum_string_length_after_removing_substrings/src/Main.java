import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == 'B') {
                if (!stack.isEmpty() && stack.peek() == 'A') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else if (ch == 'D') {
                if (!stack.isEmpty() && stack.peek() == 'C') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().minLength(scanner.next()));
       }
       
       scanner.close();
   }
}
