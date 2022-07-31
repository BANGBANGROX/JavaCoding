//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution {
    private void dfs(int x, int y, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'O') return;

        grid[x][y] = 'O';

        dfs(x + 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x - 1, y, grid);
        dfs(x, y - 1, grid);
    }

    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid) {
        // code here
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'X') {
                    dfs(i, j, grid);
                    ++ans;
                }
            }
        }

        return ans;
    }
}