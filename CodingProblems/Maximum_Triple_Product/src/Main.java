//{ Driver Code Starts
//Initial Template for Java import java.io.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String[] input_line = in.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            long x = ob.maxProductSum(N, arr);
            System.out.println(x);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private long[][] dp;
    private final ArrayList<Long> nums = new ArrayList<>();

    private long maxProductSumUtil(int l, int r) {
        if (l > r) return 0;

        if (l == r) return nums.get(l - 1) * nums.get(l) * nums.get(l + 1);

        if (dp[l][r] != -1) return dp[l][r];

        long ans = 0;

        for (int i = l; i <= r; ++i) {
            ans = Math.max(ans, maxProductSumUtil(l, i - 1) +
                    nums.get(l - 1) * nums.get(i) * nums.get(r + 1) +
                    maxProductSumUtil(i + 1, r));
        }

        return dp[l][r] = ans;
    }

    public long maxProductSum(int n, int[] arr) {
        // code here
        for (int x : arr) {
            nums.add((long) x);
        }

        dp = new long[n + 2][n + 2];

        for (int i = 0; i <= n + 1; ++i) {
            Arrays.fill(dp[i], -1);
        }

        nums.add(1L);
        nums.add(0, 1L);

        return maxProductSumUtil(1, n);
    }
}