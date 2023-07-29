//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            int[] A = IntArray.input(br, N);

            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public long findMaxSubsetSum(int n, int[] nums) {
        // code here
        long[][] dp = new long[n][2];

        dp[0][1] = nums[0];

        for (int i = 1; i < n; ++i) {
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + nums[i];
            dp[i][0] = dp[i - 1][1];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}