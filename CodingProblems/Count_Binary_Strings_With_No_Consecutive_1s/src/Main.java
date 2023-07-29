//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            long N = Long.parseLong(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.countStrings(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private final int MOD = (int) 1e9 + 7;

    private void multiplyMatrix(long[][] a, long[][] b) {
        long w = ((a[0][0] * b[0][0]) % MOD + (a[0][1] * b[1][0]) % MOD) % MOD;
        long x = ((a[0][0] * b[0][1]) % MOD + (a[0][1] * b[1][1]) % MOD) % MOD;
        long y = ((a[1][0] * b[0][0]) % MOD + (a[1][1] * b[1][0]) % MOD) % MOD;
        long z = ((a[1][0] * b[0][1]) % MOD + (a[1][1] * b[1][1]) % MOD) % MOD;

        a[0][0] = w;
        a[0][1] = x;
        a[1][0] = y;
        a[1][1] = z;
    }

    private long[][] binaryMatrixExponentiation(long[][] matrix, long n) {
        long[][] result = {{1, 0}, {0, 1}};

        while (n > 0) {
            if ((n & 1) > 0) {
                multiplyMatrix(result, matrix);
                --n;
            }
            multiplyMatrix(matrix, matrix);
            n >>= 1;
        }

        return result;
    }

    public int countStrings(long n) {
        // Code here
        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] answer = binaryMatrixExponentiation(matrix, n);

        return (int) ((answer[0][0] + answer[0][1]) % MOD);
    }
}