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
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array, n));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public long ValidPair(int[] nums, int n) {
        // Your code goes here
        int l = 0;
        int r = n - 1;
        long ans = 0;

        Arrays.sort(nums);

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > 0) {
                ans += (r - l);
                --r;
            }
            else ++l;
        }

        return ans;
    }
}
