//{ Driver Code Starts
//Initial template for Java

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if (ob.recreationalSpot(arr, n))
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
// } Driver Code Ends


//User function template for C++

class Solution {
    public boolean recreationalSpot(int[] nums, int n) {
        // Your code goes here
        int last = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        // The top of the stack is the middle (largest)
        // last is the second largest
        // We find nums[i] such that nums[i] < last and as mentioned above
        // st.peek() > last
        // Hence we get the nums as
        // nums[i], st.peek(), last

        for (int i = 0; i < n; ++i) {
            if (nums[i] < last) return true;
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                last = nums[st.pop()];
            }
            st.push(i);
        }

        return false;
    }
}