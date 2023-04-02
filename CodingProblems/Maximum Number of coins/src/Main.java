//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>(N);
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(str[i]));
            }
            Solution obj = new Solution();
            System.out.println(obj.maxCoins(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private int[][] dp;
    private int[] nums;

    private int maxCoinsUtil(int i, int j) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int result = 0;

        for (int k = i; k <= j; ++k) {
            result = Math.max(result, maxCoinsUtil(i, k - 1) + nums[i - 1] *
                    nums[k] * nums[j + 1] + maxCoinsUtil(k + 1, j));
        }

        return dp[i][j] = result;
    }

    public int maxCoins(int n, ArrayList<Integer> arr) {
        //Write your code here
        nums = new int[n + 2];
        dp = new int[n + 1][n + 1];

        nums[0] = nums[n + 1] = 1;

        for (int i = 0; i < n; ++i) {
            nums[i + 1] = arr.get(i);
        }

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return maxCoinsUtil(1, n);
    }
}