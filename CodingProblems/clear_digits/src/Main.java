import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        boolean[] canTake = new boolean[n];
        Stack<Integer> nonDigitsIndices = new Stack<>();
        StringBuilder answer = new StringBuilder();

        Arrays.fill(canTake, true);

        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                if (!nonDigitsIndices.isEmpty()) {
                    canTake[nonDigitsIndices.pop()] = false;
                    canTake[i] = false;
                }
            } else {
                nonDigitsIndices.push(i);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (canTake[i]) {
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().clearDigits(scanner.next()));
       }
       
       scanner.close();
   }
}
