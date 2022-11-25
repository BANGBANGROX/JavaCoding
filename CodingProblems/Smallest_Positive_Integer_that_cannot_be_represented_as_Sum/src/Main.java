//{ Driver Code Starts
//Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.smallestPositive(array));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long smallestPositive(long[] nums) {
        // Your code goes here
        Arrays.sort(nums);

        long ans = 1;

        for (long num : nums) {
            if (ans < num) return ans;
            else ans += num;
        }

        return ans;
    }
}