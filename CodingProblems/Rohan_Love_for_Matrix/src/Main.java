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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private void multiplyMatrix(long[][] a, long[][] b) {
        final int MOD = (int) 1e9 + 7;

        long w = (a[0][0] * b[0][0]) % MOD + (a[0][1] * b[1][0]) % MOD;
        long x = (a[0][0] * b[0][1]) % MOD + (a[0][1] * b[1][1]) % MOD;
        long y = (a[1][0] * b[0][0]) % MOD + (a[1][1] * b[1][0]) % MOD;
        long z = (a[1][0] * b[0][1]) % MOD + (a[1][1] * b[1][1]) % MOD;

        a[0][0] = w % MOD;
        a[0][1] = x % MOD;
        a[1][0] = y % MOD;
        a[1][1] = z % MOD;
    }

    public int firstElement(int n) {
        // code here
        final long[][] IDENTITY_MATRIX = {{1, 0}, {0, 1}};
        long[][] ans = IDENTITY_MATRIX.clone();
        long[][] b = {{1, 1}, {1, 0}};

        while (n > 0) {
            if ((n & 1) > 0) {
                multiplyMatrix(ans, b);
                --n;
            }
            multiplyMatrix(b, b);
            n >>= 1;
        }

        return (int) ans[1][0];
    }
}