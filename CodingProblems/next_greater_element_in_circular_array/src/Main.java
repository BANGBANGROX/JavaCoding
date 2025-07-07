import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        final int n = arr.length;
        final Stack<Integer> stack = new Stack<>();
        final ArrayList<Integer> answer = new ArrayList<>();

        for (int i = n - 1; i >= 0; --i) {
            stack.add(arr[i]);
        }

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            answer.add(stack.isEmpty() ? -1 : stack.peek());
            stack.add(arr[i]);
        }

        Collections.reverse(answer);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().nextLargerElement(arr));
       }
       
       scanner.close();
   }
}
