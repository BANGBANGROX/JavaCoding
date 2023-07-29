//{ Driver Code Starts
//Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();

            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution {
    public int countPartitions(int n, int d, int[] nums) {
        // Code here
        int totalSum = Arrays.stream(nums).sum();

        if (((totalSum + d) & 1) > 0) return 0;

        int partitionSum = (totalSum + d) / 2;
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][partitionSum + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
            if (i > 0) {
                for (int sum = 0; sum <= partitionSum; ++sum) {
                    dp[i][sum] = dp[i - 1][sum];
                    if (nums[i - 1] <= sum) {
                        dp[i][sum] = (dp[i][sum] + dp[i - 1][sum - nums[i - 1]]) % MOD;
                    }
                }
            }
        }

        return (int) dp[n][partitionSum];
    }
}