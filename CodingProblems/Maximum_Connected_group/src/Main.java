//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[][] grid;
    private int n;
    private boolean taken;

    private int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == -1) return 0;

        if (grid[x][y] == 0) {
            if (taken) return 0;
            taken = true;
        }

        grid[x][y] = -1;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        int ans = 1;

        for (int i = 0; i < 4; ++i) {
            ans += dfs(x + dx[i], y + dy[i]);
        }

        return ans;
    }

    public int MaxConnection(int[][] grid) {
        //Your code here
        int ans = 0;
        n = grid.length;
        this.grid = grid;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                taken = false;
                ans += dfs(i, j);
            }
        }

        return ans;
    }
}