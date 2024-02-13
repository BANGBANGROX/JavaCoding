//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            int[][] grid = IntMatrix.input(br, N);

            Solution obj = new Solution();
            int res = obj.maximumCoins(N, grid);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private int n;

    private int maximumCoinsHandler(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) return 0;

        int[][] directions = {{-1 ,0}, {1, 0}, {0, 1}, {0, -1}};
        int result = 0;
        visited[x][y] = true;

        for (int[] direction : directions) {
            result = Math.max(result, maximumCoinsHandler(x + direction[0], y + direction[1]));
        }

        visited[x][y] = false;

        return result + grid[x][y];
    }

    public int maximumCoins(int n, int[][] grid) {
        // code here
        this.n = n;
        this.grid = grid;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i + j) % 2 == 1) {
                    visited = new boolean[n][n];
                    answer = Math.max(answer, maximumCoinsHandler(i, j));
                }
            }
        }

        return answer;
    }
}