//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N=sc.nextInt();
            String S=sc.next();

            Solution obj = new Solution();


            System.out.println(obj.CountPS(S,N));

        }

    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int CountPS(String s, int n) {
        //code here
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                }
                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (len == 2) {
                        dp[i][j] = b;
                    }
                    else dp[i][j] = (dp[i + 1][j - 1] & b);
                }
                if (dp[i][j] && len >= 2) ++ans;
            }
        }

        return ans;
    }
}