//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public int countPaths(int n){
        //code here
        if (n == 1) return 0;

        if (n == 2) return 3;

        if (n == 3) return 6;

        final int MOD = 1_000_000_007;
        long prev = 6;

        for (int i = 4; i <= n; ++i) {
            long next;
            if (i % 2 == 0) {
                next = ((prev + 1) * 3 % MOD);
            }
            else {
                next = ((prev - 1) * 3 + MOD) % MOD;
            }
            prev = next;
        }

        return (int) prev;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends