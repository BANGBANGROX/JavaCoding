//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.waysToBreakNumber(N));
        }
    }
}
// } Driver Code Ends



class Solution {
    int waysToBreakNumber(int n){
        // code here
        final int MOD = (int)1e9 + 7;

        return (int)(((long)(n + 1) * (n + 2) / 2) % MOD);
    }
}
