import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int sumSubMins(final int[] arr) {
        // code here
        final int n = arr.length;
        final int[] left = new int[n];
        final int[] right = new int[n];
        final Stack<Integer> stack = new Stack<>();
        int answer = 0;

        left[0] = -1;
        right[n - 1] = n;

        stack.push(n - 1);

        for (int i = n - 2; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = (!stack.isEmpty() ? stack.peek() : n);
            stack.push(i);
        }

        stack.clear();
        stack.push(0);

        for (int i = 1; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = (!stack.isEmpty() ? stack.peek() : -1);
            stack.push(i);
        }

        for (int i = 0; i < n; ++i) {
            final int leftCount = (i - left[i] - 1);
            final int rightCount = (right[i] - i - 1);
            final int totalCount = leftCount + rightCount + leftCount * rightCount + 1;
            answer += arr[i] * totalCount;
        }

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

           System.out.println(new Solution().sumSubMins(arr));
       }
       
       scanner.close();
   }
}
