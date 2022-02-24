// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int optimalSearchTree(int keys[], int freq[], int n) {
        // code here
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = freq[i];
        }

        for (int i = 1; i < n; ++i) {
            freq[i] += freq[i - 1];
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = len + i - 1;
                int sum = freq[j] - (i > 0 ? freq[i - 1] : 0);
                dp[i][j] = Integer.MAX_VALUE;
                for (int r = i; r <= j; ++r) {
                    dp[i][j] = Math.min(dp[i][j],(i < r ? dp[i][r - 1] : 0) + (j > r ? dp[r + 1][j] : 0));
                }
                dp[i][j] += sum;
            }
        }

        return dp[0][n - 1];
    }
}
