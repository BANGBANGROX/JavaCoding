//{ Driver Code Starts
//Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < m; i++)
                b[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.maxDotProduct(n, m, a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[][] dp;
    private int[] nums1;
    private int[] nums2;
    private int m;
    private int n;

    private int maxDotProductHandler(int i, int j) {
        if (i >= nums1.length || j >= nums2.length) return 0;

        int zeroesLeft = (m - n - i + j);

        if (dp[i][j]!= -1) return dp[i][j];

        return dp[i][j] = Math.max(maxDotProductHandler(i + 1, j + 1) + nums1[i] * nums2[j],
                zeroesLeft > 0 ? maxDotProductHandler(i + 1, j) : 0);
    }

    public int maxDotProduct(int m, int n, int[] nums1, int[] nums2) {
        // Your code goes here
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.m = m;
        this.n = n;

        dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return maxDotProductHandler(0, 0);
    }
}
