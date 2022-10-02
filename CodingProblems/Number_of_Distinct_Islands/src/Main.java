//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private ArrayList<ArrayList<Integer>> cells;

    private void dfs(int x, int y, int px, int py, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return;

        cells.add(new ArrayList<>(Arrays.asList(px - x, py - y)));
        grid[x][y] = 0;

        dfs(x - 1, y, px, py, grid);
        dfs(x + 1, y, px, py, grid);
        dfs(x, y - 1, px, py, grid);
        dfs(x, y + 1, px, py, grid);
    }


    public int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<ArrayList<ArrayList<Integer>>> visited = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    cells = new ArrayList<>();
                    dfs(i, j, i, j, grid);
                    visited.add(cells);
                }
            }
        }

        return visited.size();
    }
}
