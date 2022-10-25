//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();

            int matrix[][] = new int[n][n];

            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<Integer> downwardDigonal(int n, int[][] matrix) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int g = 0;

        while (g < n) {
            int i = 0;
            int j = g;
            while (i <= g && j >= 0) {
                ans.add(matrix[i][j]);
                ++i;
                --j;
            }
            ++g;
        }

        for (int i = 1; i < n; ++i) {
            int k = i;
            for (int j = n - 1; j >= i; --j) {
                ans.add(matrix[k][j]);
                ++k;
            }
        }

        return ans;
    }
}
