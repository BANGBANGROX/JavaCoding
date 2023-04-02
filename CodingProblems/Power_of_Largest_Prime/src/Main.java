//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(in.readLine());

            Solution ob = new Solution();
            if (ob.largePrime(n) == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int largePrime(long n) {
        // code here
        int lastPower = 0;

        for (int i = 2; (long) i * i <= n; ++i) {
            if (n % i == 0) {
                int currentPower = 0;
                while (n % i == 0) {
                    n /= i;
                    ++currentPower;
                }
                lastPower = currentPower;
            }
        }

        if (n > 1) return 0;

        return lastPower > 1 ? 1 : 0;
    }
}