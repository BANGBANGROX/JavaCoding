//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc=new Scanner(System.in);

        //taking total testcases
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            //taking the String
            String s=sc.nextLine();
            Solution ob = new Solution();
            //calling method sumSubstrings()
            System.out.println(ob.sumSubstrings(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to find sum of all possible substrings of the given string.
    public long sumSubstrings(String s) {
        // Your code here
        final int MOD = (int) 1e9 + 7;
        int n = s.length();
        long tenValue = 1;
        long answer = 0;
        long prev = 0;

        for (int i = n - 1; i >= 0; --i) {
            int dig = s.charAt(i) - '0';
            tenValue = (tenValue * 10 + 1) % MOD;
            prev = (prev + tenValue * dig) % MOD;
            answer = (answer + prev) % MOD;
        }

        return answer;
    }
}