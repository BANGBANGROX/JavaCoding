//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");

            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);
            long n = Long.parseLong(S[3]);
            long m = Long.parseLong(S[4]);

            Solution ob = new Solution();
            System.out.println(ob.genFibNum(a,b,c,n,m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private void multiplyMatrix(long[][] a, long[][] b, long MOD) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    res[i][j] = (res[i][j] + (a[i][k] * b[k][j]) % MOD) % MOD;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            System.arraycopy(res[i], 0, a[i], 0, n);
        }
    }

    private void matrixExponentiation(long a, long b, long n, long m, long[][] ans) {
        long[][] startingMatrix = {{a, b, 1}, {1, 0, 0}, {0, 0, 1}};

        while (n > 0) {
            if ((n & 1) > 0) {
                multiplyMatrix(ans, startingMatrix, m);
                --n;
            }
            multiplyMatrix(startingMatrix, startingMatrix, m);
            n >>= 1;
        }
    }

    public long genFibNum(long a, long b, long c, long n, long m) {
        // code here
        long[][] ans = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        if (n <= 2) return 1 % m;

        matrixExponentiation(a, b, n - 2, m, ans);

        return (ans[0][0] + ans[0][1] + c * ans[0][2]) % m;
    }
}