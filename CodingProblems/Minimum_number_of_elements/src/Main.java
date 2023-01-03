//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] Arr = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCount(Arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int minCount(int[] nums, int n) {
        //code here.
        int[][][] dp = new int[n + 1][n + 2][n + 2];

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j <= n + 1; ++j) {
                for (int k = 1; k <= n + 1; ++k) {
                    if (i > 0) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j == n + 1 || nums[i - 1] < nums[j - 1]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][i][k] + 1);
                        }
                        if (k == n + 1 || nums[i - 1] > nums[k - 1]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][i] + 1);
                        }
                    }
                }
            }
        }

        return n - dp[n][n + 1][n + 1];
    }
}
