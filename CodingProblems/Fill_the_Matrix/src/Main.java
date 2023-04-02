//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public int minIteration(int m, int n, int x, int y) {
        //code here
        Queue<int[]> q = new LinkedList<>();
        int[][] grid = new int[m][n];
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        int ans = 0;

        q.add(new int[]{x, y});
        grid[x][y] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int[] cell = q.poll();
                int currX = cell[0];
                int currY = cell[1];
                for (int j = 0; j < 4; ++j) {
                    int newX = currX + dx[j];
                    int newY = currY + dy[j];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            ++ans;
        }

        return ans;
    }
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
            input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }

    }
}
// } Driver Code Ends