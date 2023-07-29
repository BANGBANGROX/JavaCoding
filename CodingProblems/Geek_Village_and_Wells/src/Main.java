//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            String[] s = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] c = new char[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    c[i][j] = s[j].charAt(0);
                }
            }
            Solution ob = new Solution();
            int[][] ans = ob.chefAndWells(n, m, c);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public int[][] chefAndWells(int m, int n, char[][] grid) {
        int[][] answer = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'W') {
                    queue.add(new int[]{i, j});
                }
                else {
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                assert cell != null;
                int x = cell[0];
                int y = cell[1];
                int[] dx = {1, 0, 0, -1};
                int[] dy = {0, 1, -1, 0};
                for (int j = 0; j < 4; ++j) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != 'N' &&
                            answer[newX][newY] > answer[x][y] + 1) {
                        answer[newX][newY] = answer[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (answer[i][j] == Integer.MAX_VALUE) {
                    if (grid[i][j] == 'H') {
                        answer[i][j] = -1;
                    }
                    else {
                        answer[i][j] = 0;
                    }
                }
                else {
                    if (grid[i][j] == 'H') {
                        answer[i][j] *= 2;
                    }
                    else {
                        answer[i][j] = 0;
                    }
                }
            }
        }

        return answer;
    }
}