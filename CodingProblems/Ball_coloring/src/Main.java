//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.noOfWays(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public long noOfWays(long n) {
        // code here
        if (n <= 2) return n * 2;

        return n * n - n + 2;
    }
}