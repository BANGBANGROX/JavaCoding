import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        int n = formula.length();

        stack.push(new HashMap<>());

        for (int i = 0; i < n;) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                ++i;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                ++i;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    ++i;
                }
                int cnt = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + value * cnt);
                }
            } else {
                int start = i;
                ++i;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    ++i;
                }
                String element = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    ++i;
                }
                int cnt = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + cnt);
            }
        }

        Map<String, Integer> overallCount = stack.pop();
        ArrayList<String> elements = new ArrayList<>(overallCount.keySet());
        StringBuilder answer = new StringBuilder();

        Collections.sort(elements);

        for (String element : elements) {
            answer.append(element);
            if (overallCount.get(element) > 1) {
                answer.append(overallCount.get(element));
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
            System.out.println(new Solution().countOfAtoms(scanner.next()));
        }

        scanner.close();
    }
}
