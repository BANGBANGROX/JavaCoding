//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)throws IOException
    {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input_line = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    private long nCr(long n, long r) {
        long res = 1;

        for (long i = 0; i < r; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    long count(long n) {
        // Code Here
        long ans = 0;
        int pos = 0;
        int ones = 0;

        while (n > 0) {
            if ((n & 1) > 0) {
                ++ones;
                ans += nCr(pos, ones);
            }
            ++pos;
            n >>= 1;
        }

        return ans;
    }
}