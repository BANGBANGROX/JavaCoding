//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private long calculateGCD(long a, long b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    public long maxGcd(int n) {
        // code here
        long ans = 1;
        int cnt = 0;

        while (n > 0) {
            if (calculateGCD(ans, n) == 1) {
                ans *= n;
                ++cnt;
            }
            if (cnt == 4) break;
            --n;
        }

        return ans;
    }
}