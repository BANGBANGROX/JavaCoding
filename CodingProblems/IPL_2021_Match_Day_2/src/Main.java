//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Initializing an array of size n
            int[] arr = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (Integer re : res) System.out.print(re + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> max_of_subarrays(int[] nums, int n, int k) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < k; ++i) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.pollLast();
            dq.add(i);
        }

        for (int i = k; i < n; ++i) {
            ans.add(nums[dq.getFirst()]);
            while (!dq.isEmpty() && dq.getFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.pollLast();
            dq.add(i);
        }

        ans.add(nums[dq.getFirst()]);

        return ans;
    }
}