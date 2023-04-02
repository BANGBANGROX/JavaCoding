import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        Solution solution = new Solution();
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] building = new char[n][m];
            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++)
                    building[i][j] = s[j].charAt(0);
            }


            int[][] ans = solution.shortestDistanceFromTheBomb(building, n, m);

            for (int[] x : ans) {
                for (int c : x)
                    ot.print(c + " ");
                ot.println();
            }
        }
        ot.close();

    }
}// } Driver Code Ends


class Solution {
    public int[][] shortestDistanceFromTheBomb(char[][] building, int m, int n) {
        // Code Here.
        int[][] ans = new int[m][n];
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (building[i][j] == 'B') {
                    q.add(new int[]{i, j});
                }
                else if (building[i][j] == 'W') {
                    ans[i][j] = -1;
                }
                else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && ans[newX][newY] > ans[x][y] + 1) {
                    ans[newX][newY] = ans[x][y] + 1;
                    q.add(new int[]{newX, newY});
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ans[i][j] == Integer.MAX_VALUE) {
                    ans[i][j] = -1;
                }
            }
        }

        return ans;
    }
}