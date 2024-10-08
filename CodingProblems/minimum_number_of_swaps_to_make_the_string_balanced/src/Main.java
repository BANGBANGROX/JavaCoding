import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
        }

        return (stack.size() + 1) / 2;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().minSwaps(scanner.next()));
       }
       
       scanner.close();
   }
}
