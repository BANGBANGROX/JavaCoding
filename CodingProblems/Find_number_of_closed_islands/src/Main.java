//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }

            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[][] matrix;
    private int m;
    private int n;

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 0) return;

        matrix[x][y] = 0;

        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }

    public int closedIslands(int[][] matrix, int m, int n) {
        // Code here
        this.matrix = matrix;
        this.m = m;
        this.n = n;
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            if (matrix[i][n - 1] == 1) dfs(i, n - 1);
            if (matrix[i][0] == 1) dfs(i, 0);
        }

        for (int i = 0; i < n; ++i) {
            if (matrix[m - 1][i] == 1) dfs(m - 1, i);
            if (matrix[0][i] == 1) dfs(0, i);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    ++ans;
                    dfs(i, j);
                }
            }
        }

        return ans;
    }
}