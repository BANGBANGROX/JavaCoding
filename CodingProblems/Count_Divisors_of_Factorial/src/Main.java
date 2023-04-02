//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.totalDivisors(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] spf;
    private HashMap<Long, Long> powerValue;

    private void calculateSpf(long n) {
        spf = new int[(int) n + 1];

        for (int i = 1; i <= n; ++i) {
            spf[i] = i;
        }

        for (int i = 2; i <= n; ++i) {
            if (spf[i] == i) {
                for (int j = 2 * i; j <= n; j += i) {
                    spf[j] = i;
                }
            }
        }
    }

    private void calculatePFPowers(long num) {
        int primeNum = spf[(int) num];

        if (primeNum == 1) return;

        while (primeNum != 1) {
            long cnt = powerValue.getOrDefault((long) primeNum, 0L);
            while (num % primeNum == 0) {
                num /= primeNum;
                ++cnt;
            }
            powerValue.put((long) primeNum, cnt);
            primeNum = spf[(int) num];
        }
    }

    public long totalDivisors(long n) {
        // code here
        long ans = 1;
        powerValue = new HashMap<>();

        calculateSpf(n);

        for (int i = 1; i <= n; ++i) {
            calculatePFPowers(i);
        }

        for (long x : powerValue.keySet()) {
            ans *= (powerValue.get(x) + 1);
        }

        return ans;
    }
}