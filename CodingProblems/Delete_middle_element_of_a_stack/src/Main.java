//{ Driver Code Starts
//Initial template for Java

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int sizeOfStack = sc.nextInt();
            Stack<Integer> myStack = new Stack<>();

            //adding elements to the stack
            for (int i = 0; i < sizeOfStack; i++) {
                int x = sc.nextInt();
                myStack.push(x);

            }
            Solution obj = new Solution();
            obj.deleteMid(myStack, sizeOfStack);

            while (!myStack.isEmpty()) {
                System.out.print(myStack.peek() + " ");
                myStack.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        Stack<Integer> auxiliaryStack = new Stack<>();
        int index = 0;
        int midIndex = sizeOfStack / 2;

        while (!s.isEmpty()) {
            if (index != midIndex) {
                auxiliaryStack.push(s.pop());
            }
            else {
                s.pop();
            }
            ++index;
        }

        while (!auxiliaryStack.isEmpty()) {
            s.push(auxiliaryStack.pop());
        }
    }
}