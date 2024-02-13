//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
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

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int[][] grid = IntMatrix.input(br, n, n);

            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private int[][] grid;
    private int n;
    private int cnt;

    private void dfs(int x, int y, boolean includeZero) {
        if (x < 0 || y < 0 || x >= n || y >= n ||
                (grid[x][y] == 0 && !includeZero) || grid[x][y] == -1)
            return;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        ++cnt;
        grid[x][y] = -1;

        for (int[] direction : directions) {
            dfs(x + direction[0], y + direction[0], false);
        }
    }

    public int largestIsland(int n, int[][] grid) {
        // code here
        this.n = n;
        this.grid = grid;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j, true);
                    answer = Math.max(answer, cnt);
                }
            }
        }

        if (answer == 0) answer = n * n;

        return answer;
    }
}
