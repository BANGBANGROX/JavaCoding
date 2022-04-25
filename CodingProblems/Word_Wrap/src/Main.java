// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k) {
        // Code here
        int n = nums.length;
        int[][] space = new int[n + 1][n + 1];
        int[][] cost = new int[n + 1][n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            space[i][i] = k - nums[i - 1];
            for (int j = i + 1; j <= n; ++j) {
                space[i][j] = space[i][j - 1] - nums[j - 1] - 1;
            }
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                if (space[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
                else if (j == n) cost[i][j] = 0;
                else cost[i][j] = space[i][j] * space[i][j];
            }
        }

        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; ++j) {
                if (dp[j - 1] != Integer.MAX_VALUE && cost[j][i] != Integer.MAX_VALUE &&
                        dp[i] > dp[j - 1] + cost[j][i]) {
                    dp[i] = dp[j - 1] + cost[j][i];
                }
            }
        }

        return dp[n];
    }
}