//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(a, n));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] nums, int n) {
        // Your code here
        int answer = 0;
        int[] leftSmallerElement = new int[n];
        int[] rightSmallerElement = new int[n];
        Stack<Integer> numberStack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!numberStack.isEmpty() && numberStack.peek() >= nums[i]) {
                numberStack.pop();
            }
            leftSmallerElement[i] = (numberStack.isEmpty() ? 0 : numberStack.peek());
            numberStack.push(nums[i]);
        }

        numberStack.clear();

        for (int i = n - 1; i >= 0; --i) {
            while (!numberStack.isEmpty() && numberStack.peek() >= nums[i]) {
                numberStack.pop();
            }
            rightSmallerElement[i] = (numberStack.isEmpty() ? 0 : numberStack.peek());
            numberStack.push(nums[i]);
        }

        for (int i = 0; i < n; ++i) {
            answer = Math.max(answer, Math.abs(leftSmallerElement[i] - rightSmallerElement[i]));
        }

        return answer;
    }
}