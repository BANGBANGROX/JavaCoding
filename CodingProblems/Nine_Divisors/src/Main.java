//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution {
    public long nineDivisors(long n){
        //Code Here
        int MAX_N = (int)Math.sqrt(n);
        boolean[] sieve = new boolean[MAX_N + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        Arrays.fill(sieve, true);

        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= MAX_N; ++i) {
            if (sieve[i]) {
                primes.add(i);
                for (int j = 2 * i; j <= MAX_N; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int len = primes.size();
        int l = 0;
        int r = len - 1;
        long ans = 0;

        while (l < r) {
            long prod = (long)primes.get(l) * primes.get(r);
            if (prod <= MAX_N) {
                ans += (r - l);
                ++l;
            }
            else --r;
        }

        for (int prime : primes) {
            long val = (long)prime * prime * prime * prime;
            if (val > MAX_N) break;
            else ++ans;
        }

        return ans;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nineDivisors(N));
        }
    }
}
// } Driver Code Ends