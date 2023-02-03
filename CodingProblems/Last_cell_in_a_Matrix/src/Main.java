//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String[] str = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int[][] matrix = new int[r][c];

            for (int i = 0; i < r; i++) {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = Integer.parseInt(str[k]);
                    k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix, r, c);
            out.print("(" + p[0] + ", " + p[1] + ")" + "\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] endPoints(int[][] matrix, int m, int n) {
        //code here
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        int[] next = {1, 3, 0, 2};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int nextDir = cell[2];
            if (matrix[x][y] == 1) {
                nextDir = next[nextDir];
                matrix[x][y] = 0;
            }
            int newX = x + dx[nextDir];
            int newY = y + dy[nextDir];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n) return new int[]{x, y};
            q.add(new int[]{newX, newY, nextDir});
        }

        return new int[]{-1, -1};
    }
}