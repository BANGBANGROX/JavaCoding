//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

class GfG
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.isDivisible(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int binExp(int a, int b) {
        int res = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % 3;
                --b;
            }
            a = (a * a) % 3;
            b /= 2;
        }

        return res;
    }

    int isDivisible(String s) {
        // code here
        int n = s.length();
        int rem = 0;

        for (int i = n - 1; i >= 0; --i) {
            rem = (rem + (s.charAt(i) - '0') * binExp(2, n + 1 - i)) % 3;
        }

        return rem == 0 ? 1 : 0;
    }
}