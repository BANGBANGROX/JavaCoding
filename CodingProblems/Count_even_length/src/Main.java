//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.compute_value(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private final int MOD = (int) 1e9 + 7;

    private long binExp(long a) {
        long res = 1;
        long b = MOD - 2;

        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }

    public int compute_value(int n) {
        // code here
        long[] factorial = new long[2 * n + 1];

        factorial[0] = 1;

        for (int i = 1; i <= 2 * n; ++i) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long val1 = factorial[2 * n];
        long val2 = factorial[n];
        long val3 = binExp(val2);
        long val4 = (val3 * val3) % MOD;
        long ans = (val1 * val4) % MOD;

        return (int) ans;
    }
}