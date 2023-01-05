//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int S = Integer.parseInt(input_line[1]);
            int X = Integer.parseInt(input_line[2]);
            String ans = ob.toughProblem(N, S, X);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends


//User function Template for Java


class Solution {
    public String toughProblem(int n, int s, int x) {
        // Code here
        String[] ans = {"Yes", "No"};

        if (s < x || (s + x) % 2 == 1) return ans[1];

        if (n == 1) {
            return s == x ? ans[0] : ans[1];
        }

        if (n == 2) {
            int value = (s - x) / 2;

            for (int bit = 30; bit >= 0; --bit) {
                if ((value & (1 << bit)) > 0) {
                    if ((x & (1 << bit)) > 0) return ans[1];
                }
            }
        }

        return ans[0];
    }
}