//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int NthTerm(int n) {
        // code here
        boolean[] isPrime = new boolean[2 * n + 1];
        int minDiff = Integer.MAX_VALUE;
        int num = -1;

        Arrays.fill(isPrime, true);

        for (int i = 2; i <= 2 * n; ++i) {
            if (isPrime[i]) {
                if (Math.abs(n - i) < minDiff) {
                    minDiff = Math.abs(n - i);
                    num = i;
                }
                for (int j = 2 * i; j <= 2 * n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return num;
    }
}