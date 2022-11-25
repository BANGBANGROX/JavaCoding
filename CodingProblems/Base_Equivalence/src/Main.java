//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] input;
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n, m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    String baseEquiv(int n, int m) {
        // code here
        for (int base = 2; base <= 32; ++base) {
            int digits = (int)(Math.log10(n) / Math.log10(base)) + 1;
            if (digits == m) return "Yes";
        }

        return "No";
    }
}