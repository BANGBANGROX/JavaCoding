//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findCatalan(n);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private final int MOD = (int) 1e9 + 7;

    private long binExp(long a) {
        long b = MOD - 2;
        long result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = (result * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }

    private long getNCR(long n, long r) {
        if (r > n) return 0;

        long result = 1;

        for (int i = 0; i < r; ++i) {
            result = (result * (n - i)) % MOD;
            result = (result * binExp(i + 1)) % MOD;
        }

        return result;
    }

    public int findCatalan(int n) {
        // code here
        long val = getNCR(2L * n, n);

        return (int) ((val * binExp(n + 1)) % MOD);
    }
}

