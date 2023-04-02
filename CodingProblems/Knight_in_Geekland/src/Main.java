//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));

        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int knightInGeekland(int[][] matrix, int startX, int startY) {
        // Code Here.
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        boolean[][] visited = new boolean[m][n];
        ArrayList<Integer> stepWisePoints = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int totalPoints = 0;
            for (int i = 0; i < size; ++i) {
                int[] cell = q.poll();
                assert cell != null;
                int x = cell[0];
                int y = cell[1];
                totalPoints += matrix[x][y];
                for (int j = 0; j < 8; ++j) {
                    int newX = x + directions[j][0];
                    int newY = y + directions[j][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                        q.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            stepWisePoints.add(totalPoints);
        }

        // System.out.println(stepWisePoints);

        int steps = stepWisePoints.size();
        int maxScore = 0;
        int minSteps = steps;

        for (int i = steps - 1; i >= 0; --i) {
            if (stepWisePoints.get(i) + i < steps) {
                stepWisePoints.set(i, stepWisePoints.get(i) +
                        stepWisePoints.get(i + stepWisePoints.get(i)));
            }
            if (maxScore <= stepWisePoints.get(i)) {
                maxScore = stepWisePoints.get(i);
                minSteps = i;
            }
        }

        return minSteps;
    }
}
