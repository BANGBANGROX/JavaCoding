//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            for(int i = 0; i < N; i++)
                A[i] = Long.parseLong(arr[i]);

            Solution ob = new Solution();
            System.out.println(ob.countBits(N, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int countBits(int n, long[] nums) {
        // code here
        long ans = 0;
        final int MOD = (int) 1e9 + 7;

        for (int i = 31; i >= 0; --i) {
            long setBits = 0;
            long unSetBits = 0;
            for (long num : nums) {
                if ((num & (1L << i)) > 0) {
                    ++setBits;
                }
                else {
                    ++unSetBits;
                }
            }
            ans = (ans + setBits * unSetBits) % MOD;
        }

        ans = (ans + ans) % MOD;

        return (int) ans;
    }
}