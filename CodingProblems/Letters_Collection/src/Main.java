//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String[] arr = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int[][] mat = new int[n][m];
            for(int i = 0;i < n;i++){
                String[] a = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            int q = Integer.parseInt(in.readLine());
            int[][] queries = new int[q][3];
            for(int i = 0;i < q;i++){
                String[] a1 = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    queries[i][j] = Integer.parseInt(a1[j]);
            }
            Solution ob = new Solution();
            List<Integer> ans;
            ans = ob.matrixSum(n, m, mat, queries);
            for(int i = 0;i < q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<Integer> matrixSum(int m, int n, int[][] mat, int[][] queries) {
        // code here
        List<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {
            int hop = query[0];
            int x = query[1];
            int y = query[2];
            int result = 0;
            for (int i = -1 * hop; i <= hop; ++i) {
                for (int j = -1 * hop; j <= hop; ++j) {
                    if (Math.abs(i) == hop || Math.abs(j) == hop) {
                        int newX = x + i;
                        int newY = y + j;
                        if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                            result += mat[newX][newY];
                        }
                    }
                }
            }
            answer.add(result);
        }

        return answer;
    }
}