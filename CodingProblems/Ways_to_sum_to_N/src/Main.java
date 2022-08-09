//{ Driver Code Starts
//Initial Template for Java


import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int m = sc.nextInt();
            int N = sc.nextInt();
            int[] Arr = new int[m];
            for(int i = 0;i<m;i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.countWays(Arr, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int countWays(int[] nums, int target) {
        //code here.
        int[] dp = new int[target + 1];
        final int MOD = (int)1e9 + 7;

        dp[0] = 1;

        for (int sum = 1; sum <= target; ++sum) {
            for (int num : nums) {
                if (sum >= num) dp[sum] = (dp[sum] + dp[sum - num]) % MOD;
            }
        }

        return dp[target];
    }
}