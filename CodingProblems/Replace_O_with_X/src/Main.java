//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] a = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char[][] mat = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private char[][] grid;
    private int m;
    private int n;

    private void dfs(int x, int y, char ch) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 'O') return;

        grid[x][y] = ch;

        dfs(x + 1, y, ch);
        dfs(x, y + 1, ch);
        dfs(x - 1, y, ch);
        dfs(x, y - 1, ch);
    }

    public char[][] fill(int m, int n, char[][] grid) {
        // code here
        this.grid = grid;
        this.m = m;
        this.n = n;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == m - 1 || j == n - 1 || i == 0 || j == 0) && grid[i][j] == 'O') {
                    dfs(i, j, '#');
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'O') {
                    dfs(i, j, 'X');
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '#') {
                    grid[i][j] = 'O';
                }
            }
        }

        return grid;
    }
}