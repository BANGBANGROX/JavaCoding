//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            String [] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int [][] mat = new int[N][M];
            for(int i = 0; i < N; i++) {
                str = br.readLine().trim().split(" ");
                for(int j = 0; j < M; j++) {
                    mat[i][j] = Integer.parseInt(str[j]);
                }
            }
            Solution obj = new Solution();
            out.println(obj.water_flow(mat, N, M));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean[][] findCells(int[][] mat, int m, int n, int side) {
        boolean[][] ans = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        if (side == 1) {
            for (int i = 0; i < n; ++i) {
                q.add(new int[]{0, i});
                ans[0][i] = true;
            }
            for (int i = 0; i < m; ++i) {
                q.add(new int[]{i, 0});
                ans[i][0] = true;
            }
        }

        if (side == 2) {
            for (int i = 0; i < n; ++i) {
                q.add(new int[]{m - 1, i});
                ans[m - 1][i] = true;
            }
            for (int i = 0; i < m; ++i) {
                q.add(new int[]{i, n - 1});
                ans[i][n - 1] = true;
            }
        }
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && 
                        mat[newX][newY] >= mat[x][y] && !ans[newX][newY]) {
                    q.add(new int[]{newX, newY});
                    ans[newX][newY] = true;
                }
            }
        }

        return ans;
    }

   public int water_flow(int[][] mat, int m, int n) {
        //Write your code here
       boolean[][] red = findCells(mat, m, n, 1);
       boolean[][] blue = findCells(mat, m, n, 2);
       int ans = 0;

       for (int i = 0; i < m; ++i) {
           for (int j = 0; j < n; ++j) {
               if (red[i][j] && blue[i][j]) {
                   ++ans;
               }
           }
       }

       return ans;
    }
}