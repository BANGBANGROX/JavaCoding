//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String[] St = read.readLine().split(" ");

            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);

            int[][] mat = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] S = read.readLine().split(" ");
                for (int j = 0; j < m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat, n, m, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int shotestPath(int[][] mat, int m, int n, int k) {
        // code here
        int ans = 0;
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        q.add(new ArrayList<>(Arrays.asList(0, 0, k)));
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                ArrayList<Integer> currentCell = q.poll();
                assert currentCell != null;
                int x = currentCell.get(0);
                int y = currentCell.get(1);
                if (x == m - 1 && y == n - 1) return ans;
                int left = currentCell.get(2);
                for (int j = 0; j < 4; ++j) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    int newLeft = left;
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (mat[newX][newY] == 1) {
                            --newLeft;
                        }
                        if (newLeft >= 0 && !visited[newX][newY][newLeft]) {
                            visited[newX][newY][newLeft] = true;
                            q.add(new ArrayList<>(Arrays.asList(newX, newY, newLeft)));
                        }
                    }
                }
            }
            ++ans;
        }

        return -1;
    }
}