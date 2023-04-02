//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String secondSmallest(int digitSum, int digitNum) {
        // code here
        int[] digits = new int[digitNum];

        for (int i = digitNum - 1; i > 0; --i) {
            int dig = Math.min(digitSum - 1, 9);
            digits[i] = dig;
            digitSum -= dig;
        }

        if (digitSum > 9) return "-1";

        digits[0] = digitSum;

        for (int i = digitNum - 1; i > 0; --i) {
            if (digits[i] != 0 && digits[i - 1] != 9) {
                --digits[i];
                ++digits[i - 1];
                StringBuilder ans = new StringBuilder();
                for (int j = 0; j < digitNum; ++j) {
                    ans.append(digits[j]);
                }
                return ans.toString();
            }
        }

        return "-1";
    }
}