//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[][][] dp;
    private int[] coins;

    private int makeChangesUtil(int n, int k, int target) {
        if (k == 0 || target == 0) return (k == 0 && target == 0 ? 1 : 0);

        if (n == 0) return (target % coins[0] == 0 && target / coins[0] == k ? 1 : 0);

        if (dp[n][k][target] != -1) return dp[n][k][target];

        return dp[n][k][target] = makeChangesUtil(n, k - 1, target - coins[n]) |
                makeChangesUtil(n - 1, k, target);
    }

    public boolean makeChanges(int n, int k, int target, int[] coins) {
        // code here
        dp = new int[n][k + 1][target + 1];
        this.coins = coins;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= k; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return makeChangesUtil(n - 1, k, target) == 1;
    }
}