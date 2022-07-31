//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String[] a = in.readLine().trim().split("\\s+");
            int M = Integer.parseInt(a[0]);
            int N = Integer.parseInt(a[1]);
            int K = Integer.parseInt(a[2]);

            Solution ob = new Solution();
            System.out.println(ob.knots(M, N, K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    final int MOD = (int)1e9 + 7;

    private long binExp(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b /= 2;
        }

        return res;
    }

    public int knots(int m, int n, int k){
        // code here
        int MAX_N = Math.max(m, n);
        int[] factorial = new int[MAX_N + 1];

        factorial[0] = 1;

        for (int i = 1; i <= MAX_N; ++i) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long val1 = factorial[m];
        long val2 = binExp(factorial[m - k], MOD - 2);
        long val3 = binExp(factorial[k], MOD - 2);
        long res1 = (((val1 * val2) % MOD) * val3) % MOD;
        long val4 = factorial[n];
        long val5 = binExp(factorial[n - k], MOD - 2);
        long val6 = binExp(factorial[k], MOD - 2);
        long res2 = (((val4 * val5) % MOD) * val6) % MOD;
        long ans = (res1 * res2) % MOD;

        return (int)ans;
    }
}