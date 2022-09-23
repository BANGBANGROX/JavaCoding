//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());//testcases

        while (t-- > 0) {
            long n = Long.parseLong(read.readLine());//input n

            Solution ob = new Solution();
            System.out.println(ob.numberOfSquares(n));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    public long numberOfSquares(long base) {
        //code here
        long x = base / 2 - 1;

        return x * (x + 1) / 2;
    }
}