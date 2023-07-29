//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            int A;
            A = Integer.parseInt(br.readLine());


            int B;
            B = Integer.parseInt(br.readLine());


            int C;
            C = Integer.parseInt(br.readLine());


            int D;
            D = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.bestNumbers(N, A, B, C, D);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private final int MOD = (int) 1e9 + 7;

    private boolean check(long num, int c, int d) {
        while (num > 0) {
            long dig = num % 10;
            if (dig != c && dig != d) return false;
            num /= 10;
        }

        return true;
    }

    private long computeInv(long num) {
        long answer = 1;
        long pow = MOD - 2;

        while (pow > 0) {
            if ((pow & 1) > 0) {
                answer = (answer * num) % MOD;
                --pow;
            }
            num = (num * num) % MOD;
            pow >>= 1;
        }

        return answer;
    }

    public int bestNumbers(int n, int a, int b, int c, int d) {
        // code here
        long[] factorial = new long[n + 1];
        long[] invFactorial = new long[n + 1];
        long answer = 0;

        factorial[0] = 1;
        invFactorial[0] = 1;

        for (int i = 1; i <= n; ++i) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
            invFactorial[i] = computeInv(factorial[i]);
        }

        for (int i = 0; i <= n; ++i) {
            if (check((long)i * a + (long)(n - i) * b, c, d)) {
                long nci = (((factorial[n] * invFactorial[n - i]) % MOD) *
                        invFactorial[i]) % MOD;
                answer = (answer + nci) % MOD;
            }
        }

        return (int) answer;
    }
}



