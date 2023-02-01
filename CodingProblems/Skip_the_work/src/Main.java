//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minAmount(A, n));
        }
    }
}
// } Driver Code Ends



class Solution {
    private int[][] dp;
    private int n;
    private int[] nums;

    private int minAmountUtil(int idx, int skipped) {
        if (idx >= n) return 0;

        if (dp[idx][skipped] != -1) return dp[idx][skipped];

        int result = minAmountUtil(idx + 1, 0) + nums[idx];

        if (skipped == 0) {
            result = Math.min(result, minAmountUtil(idx + 1, 1));
        }

        return dp[idx][skipped] = result;
    }

    public int minAmount(int[] nums, int n) {
        //code here.
        this.nums = nums;
        this.n = n;
        dp = new int[n][2];

        for (int i = 0; i < n; ++i) {
            dp[i][0] = dp[i][1] = -1;
        }

        return minAmountUtil(0, 0);
    }
}