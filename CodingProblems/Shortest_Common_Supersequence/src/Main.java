//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;

public class Main {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc=new Scanner(System.in);

        //taking total testcases
        int t=sc.nextInt();

        sc.nextLine();
        while(t-->0)
        {
            //taking String X and Y
            String S[]=sc.nextLine().split(" ");
            String X=S[0];
            String Y=S[1];

            //calling function shortestCommonSupersequence()
            System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
        }
    }





}
// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to find length of the shortest common super sequence of two strings.
    public int shortestCommonSupersequence(String s, String t, int m, int n) {
        //Your code here
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return (m + n - dp[m][n]);
    }
}