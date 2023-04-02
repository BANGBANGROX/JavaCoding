//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int N, K, W;
            String[] str = br.readLine().trim().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);
            W = Integer.parseInt(str[2]);
            str = br.readLine().trim().split(" ");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();
            System.out.println(obj.maximizeMinHeight(N, K, W, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] height;
    private int k;
    private int n;
    private int w;

    private boolean check(long ht) {
        int cnt = 0;
        long prefSum = 0;
        long[] dp = new long[n + 1];

        for (int i = 0; i < n; ++i) {
            prefSum += dp[i];
            long currentHeight = height[i] + prefSum;
            if (currentHeight < ht) {
                long diff = ht - currentHeight;
                cnt += diff;
                prefSum += diff;
                dp[i] += diff;
                dp[Math.min(i + w, n)] -= diff;
                if (cnt > k) return false;
            }
        }

        return true;
    }

    long maximizeMinHeight(int n, int k, int w, int[] height) {
        //Write your code here
        this.n = n;
        this.k = k;
        this.w = w;
        this.height = height;
        long l = Arrays.stream(height).min().getAsInt();
        long r = l + k;
        long ans = l - 1;

        while (l <= r) {
            long mid = (l + ((r - l) >> 1));
            if (check(mid)) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return ans;
    }
}