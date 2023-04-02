// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class GFG {
    public static void main(String[] args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String[] s =in.readLine().trim().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.longestSubarray(a, b));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    public int longestSubarray(int a, int b) {
        int gcd = calculateGCD(a, b);
        a /= gcd;
        b /= gcd;
        int ans = 1;

        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        --a;
        ans += a / b;

        if (a % b == 0 && a > 0) --ans;

        return ans;
    }
}