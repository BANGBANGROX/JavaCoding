//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getSpecialNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    public long getSpecialNumber(int n) {
        //code here.
        long result = 0;
        long x = n - 1;
        long t = 1;

        while (x > 0) {
            result = (result + (x % 6) * t);
            t *= 10;
            x /= 6;
        }

        return result;
    }
}

