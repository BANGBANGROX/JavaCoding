import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> findGreater(final int[] arr) {
        // code here
        final int n = arr.length;
        final ArrayList<Integer> answer = new ArrayList<>();
        final Stack<Integer> stack = new Stack<>();
        final Map<Integer, Integer> count = new HashMap<>();

        for (final int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && count.get(arr[stack.peek()]) <= count.get(arr[i])) {
                stack.pop();
            }
            answer.add(!stack.isEmpty() ? arr[stack.peek()] : -1);
            stack.add(i);
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

           System.out.println(new Solution().findGreater(arr));
       }
       
       scanner.close();
   }
}
