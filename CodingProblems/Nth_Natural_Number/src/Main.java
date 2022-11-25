//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
   public long findNth(long n) {
        //code here
       StringBuilder ans = new StringBuilder();

       while (n > 0) {
           ans.append(n % 9);
           n /= 9;
       }

       return Long.parseLong(ans.reverse().toString());
    }
}