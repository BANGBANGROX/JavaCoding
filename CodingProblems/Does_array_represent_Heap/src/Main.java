//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long[] a = new long[(int) (n)];
            // long getAnswer[] = new long[(int)(n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1 : 0);

        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    private long[] nums;
    private long n;

    private boolean checkMaxHeap(int idx, long parentValue) {
        if (idx >= n) return true;

        if (nums[idx] > parentValue) return false;

        return checkMaxHeap(2 * idx + 1, nums[idx]) && checkMaxHeap(2 * idx + 2, nums[idx]);
    }

    public boolean countSub(long[] nums, long n) {
        // Your code goes here
        this.nums = nums;
        this.n = n;

        return checkMaxHeap(0, Long.MAX_VALUE);
    }
}