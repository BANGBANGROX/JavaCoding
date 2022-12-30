//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int[] ptr = ob.getPrimes(N);

            System.out.println(ptr[0] + " " + ptr[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] getPrimes(int n) {
        // code here
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int l = 0;
        int r = primes.size() - 1;

        while (l < r) {
            int sum = primes.get(l) + primes.get(r);
            if (sum == n) return new int[]{primes.get(l), primes.get(r)};
            else if (sum > n) --r;
            else ++l;
        }

        return new int[]{-1, -1};
    }
}