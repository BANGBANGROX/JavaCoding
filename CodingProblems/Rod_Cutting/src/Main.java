//{ Driver Code Starts

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[][] dp;
    private int[] price;

    private int cutRodUtil(int ind, int len) {
        if (ind == 0) return price[0] * len;

        if (dp[ind][len] != -1) return dp[ind][len];

        int ans = cutRodUtil(ind - 1, len);

        if (ind + 1 <= len) {
            ans = Math.max(ans, cutRodUtil(ind, len - (ind + 1)) + price[ind]);
        }

        return dp[ind][len] = ans;
    }

    public int cutRod(int[] price, int n) {
        //code here
        this.price = price;
        dp = new int[n][n + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return cutRodUtil(n - 1, n);
    }
}