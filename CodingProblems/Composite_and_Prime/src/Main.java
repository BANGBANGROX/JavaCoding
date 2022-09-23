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
            String[] S = br.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.Count(L, R);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int Count(int l, int r) {
        // code here
        int[] prime = new int[r + 1];

        Arrays.fill(prime, 1);

        for (int i = 2; i <= r; ++i) {
            if (prime[i] == 1) {
                for (int j = 2 * i; j <= r; j += i) {
                    prime[j] = 0;
                }
            }
        }

        prime[0] = prime[1] = 0;

        for (int i = 1; i <= r; ++i) {
            prime[i] += prime[i - 1];
        }

        int primeCount = prime[r] - prime[l - 1];
        int compCount = r - l - primeCount + 1;

        if (l == 1) --compCount;

        return compCount - primeCount;
    }
}