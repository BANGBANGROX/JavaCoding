//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends
//User function Template for Java

class Solution {
    private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) return;

        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; ++i) {
            dfs(x + dx[i], y + dy[i], grid, visited);
        }
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> ans = new ArrayList<>();
        int[][] grid = new int[rows][cols];

        for (int[] operator : operators) {
            int x = operator[0];
            int y = operator[1];
            int res = 0;
            boolean[][] visited = new boolean[rows][cols];

            grid[x][y] = 1;

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        ++res;
                        dfs(i, j, grid, visited);
                    }
                }
            }

            ans.add(res);
        }

        return ans;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] a = new int[k][2];
            for (int i = 0; i < k; i++) {

                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n, m, a);

            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends