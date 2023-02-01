//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int[][] grid;
    private int m;
    private int n;
    private int currentSize;
    private boolean result;

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            result = false;
            return;
        }

        if (grid[x][y] == 0) return;

        ++currentSize;
        grid[x][y] = 0;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        for (int i = 0; i < 4; ++i) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    public int numberOfEnclaves(int[][] grid) {
        // Your code here
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    currentSize = 0;
                    result = true;
                    dfs(i, j);
                    if (result) ans += currentSize;
                }
            }
        }

        return ans;
    }
}