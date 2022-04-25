// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG{
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String[] a = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);

            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    private boolean checkPrime(long n) {
        for (long i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public long primeProduct(long l, long r){
        // code here
        long ans = 1;
        final int mod = (int)1e9 + 7;

        for (long i = l; i <= r; ++i) {
            if (checkPrime(i)) {
                ans = (ans * i) % mod;
            }
        }

        return ans;
    }
}