import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                deque.push(answer.length());
            } else if (ch == ')') {
                int startIndex = deque.pop();
                StringBuilder reverseStringBuilder = new StringBuilder(answer.substring(startIndex)).reverse();
                answer.replace(startIndex, answer.length(), reverseStringBuilder.toString());
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().reverseParentheses(scanner.next()));
        }

        scanner.close();
    }
}

// (a(bc)d) -> dbca

// a cb d