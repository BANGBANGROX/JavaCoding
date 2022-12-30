//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxCoins(n,a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] nums;
    private int[][] dp;

    private int maxCoinsUtil(int i, int j) {
        if (i > j) return 0;

        if (i == j) return nums[i - 1] * nums[i] * nums[i + 1];

        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        for (int k = i; k <= j; ++k) {
            ans = Math.max(ans, maxCoinsUtil(i, k - 1) +
                    nums[i - 1] * nums[k] * nums[j + 1] + maxCoinsUtil(k + 1, j));
        }

        return dp[i][j] = ans;
    }

    public int maxCoins(int n, int[] nums) {
        // code here
        ArrayList<Integer> newNums = new ArrayList<>();

        for (int x : nums) {
            newNums.add(x);
        }

        newNums.add(1);
        newNums.add(0, 1);

        this.nums = newNums.stream().mapToInt(a -> a).toArray();
        dp = new int[n + 1][n + 1];


        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return maxCoinsUtil(1, n);
    }
}
     