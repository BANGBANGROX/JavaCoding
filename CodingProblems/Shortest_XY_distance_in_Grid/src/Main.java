//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String[] S1 = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int shortestXYDist(ArrayList<ArrayList<Character>> grid, int m,
                              int n) {
        // code here
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[m][n];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == 'X') {
                    q.add(new int[]{i, j});
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            assert cell != null;
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n &&
                        distance[newX][newY] > distance[x][y] + 1) {
                    q.add(new int[]{newX, newY});
                    distance[newX][newY] = distance[x][y] + 1;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == 'Y') {
                    ans = Math.min(ans, distance[i][j]);
                }
            }
        }

        return ans;
    }
}