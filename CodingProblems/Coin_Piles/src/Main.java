// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S1 = read.readLine().split(" ");
            int N = Integer.parseInt(S1[0]);
            int K = Integer.parseInt(S1[1]);

            String[] S = read.readLine().split(" ");
            int[] A = new int[N];

            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minSteps(A,N,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private int upperBound(int[] coins, int n, int key) {
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (coins[mid] <= key) l = mid + 1;
            else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }

    public int minSteps(int[] coins, int n, int k) {
        // code here
        int ans = Integer.MAX_VALUE;
        int previousCoins = 0;
        int[] prefixSum = new int[n];

        Arrays.sort(coins);

        for (int i = 0; i < n; ++i) {
            prefixSum[i] = (i == 0) ? coins[i] : coins[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (i + 1 < n && coins[i] == coins[i + 1]) {
                ++count;
                ++i;
            }
            int required = coins[i] + k;
            int idx = upperBound(coins, n, required);
            int actualSum = prefixSum[n - 1] - prefixSum[idx - 1];
            int requiredSum = required * (n - idx);
            ans = Math.min(ans, actualSum - requiredSum + previousCoins);
            previousCoins += coins[i] * count;
        }

        return ans;
    }
}