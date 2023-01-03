//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");

            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A, N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[][] dp;
    private int[] nums;
    private int n;
    private int target;
    private final int OFFSET = (int) 1e5;

    private int findTargetSumWaysUtil(int idx, int sum) {
        if (idx >= n) return sum == target ? 1 : 0;

        if (dp[idx][sum + OFFSET] != -1) return dp[idx][sum + OFFSET];

        int ans = findTargetSumWaysUtil(idx + 1, sum + nums[idx]) +
                findTargetSumWaysUtil(idx + 1, sum - nums[idx]);

        dp[idx][sum + OFFSET] = ans;

        return ans;
    }

    public int findTargetSumWays(int[] nums, int n, int target) {
        // code here
        this.nums = nums;
        this.n = n;
        this.target = target;
        dp = new int[n][4 * OFFSET];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return findTargetSumWaysUtil(0, 0);
    }
}