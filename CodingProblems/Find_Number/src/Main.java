//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            long n = Long.parseLong(in.readLine());
            Solution ob = new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public long findNumber(long n) {
         long answer = 0;
         long number = 1;
         int[] oddNumbers = {9, 1, 3, 5, 7};

         while (n > 0) {
             int idx = (int) (n % 5);
             answer += oddNumbers[idx] * number;
             n /= 5;
             if (idx == 0) --n;
             number *= 10;
         }

         return answer;
    }
}